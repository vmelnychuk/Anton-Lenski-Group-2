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

@MessageDriven(name = "MDBService", activationConfig = { 
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/test"), 
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
        })
public class MDBService implements MessageListener {
    static Logger logger = Logger.getLogger(MDBService.class);
    @EJB
    EmailService emailService;
    public MDBService() {
    }
    public void onMessage(Message message) {
        ObjectMessage payload = (ObjectMessage) message;
        try {
            Attendee attendee = (Attendee) payload.getObject();
            String email = createMessage();
            logger.info("Get attendee with JMS: " + attendee.toString());
            emailService.sendMail(attendee, email);
        } catch(JMSException e) {
            logger.error("Error ! " + e);
        }
    }
    public String createMessage() {
        for (int i = 1; i < 4; i++) {
            logger.info(i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "==message created as background task==";
    }
}
