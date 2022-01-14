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

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import org.acme.beans.ConfigurationProperty;
import org.acme.beans.UpdateConfigurationProperty;

/**
 * Implementation of the /admin REST API operations.
 *
 * @author eric.wittmann@gmail.com
 */
@ApplicationScoped
public class AdminResourceImpl implements AdminResource {

    @Inject
    PropertiesStorage storage;

    @Override
    public List<ConfigurationProperty> listConfigProperties() {
        return storage.getPropertyNames().stream().map(name -> ConfigurationProperty.builder().name(name).value(storage.getValue(name)).build()).collect(Collectors.toList());
    }

    @Override
    public void setConfigProperty(ConfigurationProperty data) {
        storage.setPropertyValue(data.getName(), data.getValue());
    }

    @Override
    public ConfigurationProperty getConfigProperty(String propertyName) {
        if (storage.hasProperty(propertyName)) {
            return ConfigurationProperty.builder().name(propertyName).value(storage.getValue(propertyName)).build();
        } else {
            throw new NotFoundException("Property " + propertyName + " not found.");
        }
    }

    @Override
    public void updateConfigProperty(String propertyName, UpdateConfigurationProperty data) {
        ConfigurationProperty cp = new ConfigurationProperty();
        cp.setName(propertyName);
        cp.setValue(data.getValue());
        this.setConfigProperty(cp);
    }

    @Override
    public void deleteConfigProperty(String propertyName) {
        storage.deleteProperty(propertyName);
    }

}
