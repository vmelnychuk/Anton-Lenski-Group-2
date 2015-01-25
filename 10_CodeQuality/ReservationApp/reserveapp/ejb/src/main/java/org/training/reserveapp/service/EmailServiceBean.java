package org.training.reserveapp.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.service.exception.EmailServiceException;

@Stateless
public class EmailServiceBean implements EmailService {
    private static Logger logger = Logger.getLogger(EmailServiceBean.class);
    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;
    @Resource(mappedName = "java:jboss/exported/jms/queue/test")
    private Queue queue;
    private Connection connection;
    @Override
    public void sendMail(Attendee attendee, String message) {
        if (attendee.getEmail().endsWith("@mail.ru")) {
            logger.error("try sent mail to " + attendee.getEmail());
            throw new EmailServiceException("User uses mail.ru mail");
        } else {
            logger.info("mail is sent to " + attendee.getEmail() 
                    + " with text " + message);
        }
    }
    @Override
    public void composeMail(Attendee attendee) {
        if (attendee.getEmail().endsWith("@mail.ru")) {
            logger.error("try sent mail to " + attendee.getEmail());
            throw new EmailServiceException("User uses mail.ru mail");
        } else {
            try {
                connection = cf.createConnection();
                Session session = connection.
                        createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer publisher = session.createProducer(queue);
                connection.start();
                ObjectMessage message = session.createObjectMessage(attendee);
                publisher.send(message);
            } catch (JMSException e) {
                logger.error("Error ! " + e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                        connection = null;
                    } catch (JMSException e) { 
                        logger.error(e); 
                    }
                }
            }
        }
    }
}
