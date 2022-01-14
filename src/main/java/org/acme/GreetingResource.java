package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@RequestScoped //marked as request scoped so the property is reloaded for each request. The same behaviour can be achieved by observing the ChangeEvent
public class GreetingResource {

    @ConfigProperty(name = "greeting.hello")
    String greetingMessage;

    @Inject
    PropertiesStorage propertiesStorage;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingMessage;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String setProperty(String greetingMessage) {
        return propertiesStorage.setPropertyValue("greeting.hello", greetingMessage);
    }
}