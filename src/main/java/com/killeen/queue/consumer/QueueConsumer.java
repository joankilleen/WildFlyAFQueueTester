package com.killeen.queue.consumer;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.killeen.queue.dto.ScenarioDTO;

@MessageDriven(name = "QueueConsumer", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class QueueConsumer implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(QueueConsumer.class.toString());

	@Override
	public void onMessage(final Message msg) {

		ObjectMessage scenarioMessage = (ObjectMessage) msg;
		String messageType = null;
		ScenarioDTO dto = null;
		try {
			messageType = scenarioMessage.getJMSType();
			dto = dto = (ScenarioDTO) scenarioMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uuid = dto.getUuid();
		LOGGER.info("QueueConsumer processed scenario: " + dto);

	}

}
