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

import java.util.function.Supplier;

import javax.enterprise.context.ApplicationScoped;

import org.acme.beans.SomeProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Implementation of the /admin REST API operations.
 *
 * @author eric.wittmann@gmail.com
 */
@ApplicationScoped
public class TestResourceImpl implements TestResource {

    @ConfigProperty(name="app.properties.static.string", defaultValue="_DEFAULT_")
    String staticString;
    @ConfigProperty(name="app.properties.static.int", defaultValue="0")
    Integer staticInt;
    @ConfigProperty(name="app.properties.static.long", defaultValue="0")
    Long staticLong;
    @ConfigProperty(name="app.properties.static.bool", defaultValue="false")
    Boolean staticBool;

    @DynamicConfigProperty(name="app.properties.dynamic.string", defaultValue="_DEFAULT_")
    Supplier<String> dynamicString;
    @DynamicConfigProperty(name="app.properties.dynamic.int", defaultValue="0")
    Supplier<Integer> dynamicInt;
    @DynamicConfigProperty(name="app.properties.dynamic.long", defaultValue="0")
    Supplier<Long> dynamicLong;
    @DynamicConfigProperty(name="app.properties.dynamic.bool", defaultValue="false")
    Supplier<Boolean> dynamicBool;

    /**
     * @see org.acme.TestResource#test()
     */
    @Override
    public SomeProperties test() {
        return SomeProperties.builder()
                .appPropertiesStaticString(staticString)
                .appPropertiesStaticInt(staticInt)
                .appPropertiesStaticBool(staticBool)
                .appPropertiesStaticLong(staticLong)
                .appPropertiesDynamicString(dynamicString.get())
                .appPropertiesDynamicInt(dynamicInt.get())
                .appPropertiesDynamicBool(dynamicBool.get())
                .appPropertiesDynamicLong(dynamicLong.get())
                .build();
    }

}
