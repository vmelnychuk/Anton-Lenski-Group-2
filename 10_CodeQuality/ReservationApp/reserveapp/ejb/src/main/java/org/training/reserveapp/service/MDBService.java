package org.training.reserveapp.service;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.service.exception.EmailServiceException;

@MessageDriven(name = "MDBService", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", 
                propertyValue = "java:jboss/exported/jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge")
})
public class MDBService implements MessageListener {
    private static Logger logger = Logger.getLogger(MDBService.class);
    public static final int TIMES = 4;
    public static final long TIMEOUT = 1500L;
    @EJB
    private EmailService emailService;
    public MDBService() {
    }
    public void onMessage(Message message) {
        ObjectMessage payload = (ObjectMessage) message;
        try {
            Attendee attendee = (Attendee) payload.getObject();
            String email = createMessage();
            logger.info("Get attendee with JMS: " + attendee.toString());
            emailService.sendMail(attendee, email);
        } catch (JMSException e) {
            logger.error("Error ! " + e);
        } catch(EmailServiceException e) {
            logger.error("Error ! " + e);
        }
    }
    public String createMessage() {
        for (int i = 1; i < TIMES; i++) {
            logger.info(i);
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "==message created as background task==";
    }
}
