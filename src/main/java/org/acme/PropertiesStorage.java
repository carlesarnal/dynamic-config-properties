package org.acme;


import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Set;

@ApplicationScoped
public class PropertiesStorage {

    private final HashMap<String, String> properties = new HashMap<>();

    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    public String getName() {
        return PropertiesStorage.class.getSimpleName();
    }

    public String setPropertyValue(String key, String value) {
        return properties.put(key, value);
    }

    public boolean hasProperty(String propertyName) {
        return properties.containsKey(propertyName);
    }

    public void deleteProperty(String propertyName) {
        properties.remove(propertyName);
    }

}