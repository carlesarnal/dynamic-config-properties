package org.acme;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class StartupConfiguration {

    @Inject
    PropertiesStorage propertiesStorage;

    void onStart(@Observes StartupEvent ev) {
        InMemoryConfigSource.setPropertiesStorage(propertiesStorage);
    }
}