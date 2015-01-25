package org.training.reserveapp.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.training.reserveapp.model.Attendee;
import org.training.reserveapp.service.EmailService;
import org.training.reserveapp.service.EmailServiceBean;
import org.training.reserveapp.service.exception.EmailServiceException;


public class EmailServiceBeanTest {

    @Test(expected=EmailServiceException.class)
    public void testComposeMail() {
        Attendee attendee = new Attendee("Bob", "Clarke", "bob@mail.ru");
        EmailService service = new EmailServiceBean();
        service.composeMail(attendee);
    }

}
