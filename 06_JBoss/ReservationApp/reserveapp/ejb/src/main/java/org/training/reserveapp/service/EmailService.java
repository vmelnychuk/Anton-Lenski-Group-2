package org.training.reserveapp.service;

import javax.ejb.Local;

import org.training.reserveapp.model.Attendee;
@Local
public interface EmailService {
    void sendMail(Attendee attendee);
}
