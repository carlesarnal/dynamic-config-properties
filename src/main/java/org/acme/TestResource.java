package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.acme.beans.SomeProperties;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/test")
public interface TestResource {
  /**
   * Operation used to print out a bunch of injected properties.
   */
  @GET
  @Produces("application/json")
  SomeProperties test();
}
