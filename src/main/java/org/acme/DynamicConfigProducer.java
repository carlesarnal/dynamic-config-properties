/*
 * Copyright 2022 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acme;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.smallrye.config.inject.ConfigProducerUtil;

/**
 * @author eric.wittmann@gmail.com
 */
@ApplicationScoped
public class DynamicConfigProducer {

    @Inject
    Config config;

    protected Config getConfig() {
        return config;
    }

    @Dependent
    @Produces
    @DynamicConfigProperty
    protected <T> Supplier<T> produceSupplierConfigValue(InjectionPoint ip) {
        InjectionPoint ip2 = new InjectionPoint() {

            private Set<Annotation> qualifiers;

            @Override
            public boolean isTransient() {
                return ip.isTransient();
            }

            @Override
            public boolean isDelegate() {
                return ip.isDelegate();
            }

            @Override
            public Type getType() {
                return ip.getType();
            }

            @Override
            public Set<Annotation> getQualifiers() {
                if (qualifiers == null) {
                    qualifiers = ip.getQualifiers().stream().map(qualifier -> {
                        if (qualifier.annotationType().equals(DynamicConfigProperty.class)) {
                            DynamicConfigProperty dcp = (DynamicConfigProperty) qualifier;
                            return new ConfigProperty() {
                                @Override
                                public Class<? extends Annotation> annotationType() {
                                    return ConfigProperty.class;
                                }
                                @Override
                                public String name() {
                                    return dcp.name();
                                }
                                @Override
                                public String defaultValue() {
                                    return dcp.defaultValue();
                                }
                            };
                        }
                        return qualifier;
                    }).collect(Collectors.toSet());
                }
                return qualifiers;
            }

            @Override
            public Member getMember() {
                return ip.getMember();
            }

            @Override
            public Bean<?> getBean() {
                return ip.getBean();
            }

            @Override
            public Annotated getAnnotated() {
                return ip.getAnnotated();
            }
        };
        return () -> ConfigProducerUtil.getValue(ip2, getConfig());
    }


}
