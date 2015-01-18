package org.training.reserveapp.service;

import javax.ejb.Stateless;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.service.exception.EmailServiceException;

@Stateless
public class EmailServiceBean implements EmailService{
    static Logger logger = Logger.getLogger(EmailServiceBean.class);
    @Override
    public void sendMail(Attendee attendee) {
        if (attendee.getEmail().endsWith("@mail.ru")) {
            logger.error("try sent mail to " + attendee.getEmail());
            throw new EmailServiceException("User uses mail.ru mail");
        } else {
            BasicConfigurator.configure();
            logger.info("mail is sent to " + attendee.getEmail());
        }
    }
}
