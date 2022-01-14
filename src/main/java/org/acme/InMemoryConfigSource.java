package org.acme;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Collections;
import java.util.Set;

public class InMemoryConfigSource implements ConfigSource {

    private static PropertiesStorage propertiesStorage;

    @Override
    public int getOrdinal() {
        return 275;
    }

    @Override
    public Set<String> getPropertyNames() {
        if (propertiesStorage != null) {
            return propertiesStorage.getPropertyNames();
        } else {
            //Not initialized yet
            return Collections.emptySet();
        }
    }

    @Override
    public String getValue(String propertyName) {
        if (propertiesStorage != null) {
            return propertiesStorage.getValue(propertyName);
        } else {
            //Not initialized yet
            return null;
        }
    }

    @Override
    public String getName() {
        return propertiesStorage.getName();
    }

    public static void setPropertiesStorage(PropertiesStorage propertiesStorage) {
        InMemoryConfigSource.propertiesStorage = propertiesStorage;
    }
}