package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/apis/studio/v1/test")
public interface TestResource {
  /**
   * Operation used to print out a bunch of injected properties.
   */
  @GET
  void test();
}
