package com.killeen.queue.consumer;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "QueueConsumer", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class QueueConsumer implements MessageListener {


	private final static Logger LOGGER = Logger.getLogger(QueueConsumer.class.toString());

    @Override
    public void onMessage(final Message msg) {
        if (msg instanceof TextMessage) {
            try {
                final String text = ((TextMessage) msg).getText();
                LOGGER.info("QueueConsumer received: " + text);
            } catch (final JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
