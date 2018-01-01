package com.killeen.queue.rest;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.killeen.queue.dto.ScenarioDTO;

@Path("")
public class WriteQueueResource {
	@Resource(mappedName = "java:/queue/test")
    Queue testQueue;
    @Inject
    JMSContext jmsContext;
    
	private static final Logger LOG = Logger.getLogger(WriteQueueResource.class.getName());
    @POST
    @Path("/write/{scenarioName}")
    @Produces({APPLICATION_JSON})
    public Response write(@PathParam("scenarioName") String scenarioName) {
        LOG.info("Reached write queue method...." + scenarioName);
        
        ScenarioDTO dto = new ScenarioDTO();
        dto.setScenarioName(scenarioName);
        dto.setUuid(UUID.randomUUID().toString());
        
        ObjectMessage message = null;
        try {
            message = jmsContext.createObjectMessage();
            message.setJMSType("SCENARIO");
            message.setObject(dto);
            jmsContext.createProducer().send(testQueue, message);
        } catch (JMSException ex) {
            LOG.info("JMS problem " + ex.getMessage());
        }
        return Response.accepted(dto).build();
    }
    
}
