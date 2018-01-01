package com.killeen.queue.rest;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Path("")
public class WriteQueueResource {
	@Resource(mappedName = "java:/queue/test")
    Queue testQueue;
    @Inject
    JMSContext jmsContext;
    
	private static final Logger LOG = Logger.getLogger(WriteQueueResource.class.getName());
    @POST
    @Path("/write/{scenarioName}")
    public Response write(@PathParam("scenarioName") String scenarioName) {
        LOG.info("Reached write queue method...." + scenarioName);
        jmsContext.createProducer().send(testQueue, scenarioName);
        return Response.accepted().build();
    }
    
}
