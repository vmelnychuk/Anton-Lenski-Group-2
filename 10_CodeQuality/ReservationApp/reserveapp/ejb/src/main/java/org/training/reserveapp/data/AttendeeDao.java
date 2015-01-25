package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.Attendee;


public interface AttendeeDao {
    List<Attendee>findAllAttendees();
    void insert(Attendee attendee);
    void update(Attendee attendee);
    void delete(Attendee attendee);
}
