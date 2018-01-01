package com.killeen.queue.rest;

import java.util.logging.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("")
public class WriteQueueResource {
    private static final Logger LOG = Logger.getLogger(WriteQueueResource.class.getName());
    @POST
    @Path("/write/{scenarioName}")
    public Response write(@PathParam("scenarioName") String scenarioName) {
        LOG.info("Reached write queue method...." + scenarioName);
        return Response.accepted().build();
    }
    
}
