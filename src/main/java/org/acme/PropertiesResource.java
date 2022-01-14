package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.acme.beans.ConfigurationProperty;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/properties")
public interface PropertiesResource {
  /**
   * Gets the value of a property.  Returns the value of any property, including
   * non-dynamic properties.
   */
  @Path("/{propertyName}")
  @GET
  @Produces("application/json")
  ConfigurationProperty getProperty(@PathParam("propertyName") String propertyName);
}
