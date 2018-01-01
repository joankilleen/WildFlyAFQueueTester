/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.killeen.queue.rest;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import javax.ws.rs.core.Response;

/**
 *
 * @author Joan
 */
@Path("test")
public class TestResource {
    private static final Logger LOG = Logger.getLogger(TestResource.class.getName());
    @GET
    public Response test() {
        LOG.info("Reached test method....");
        return Response.ok().build();
    }
    
}
