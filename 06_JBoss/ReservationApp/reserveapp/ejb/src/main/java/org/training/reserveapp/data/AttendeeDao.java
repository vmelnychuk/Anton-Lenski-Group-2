package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.Attendee;


public interface AttendeeDao {
    public List<Attendee>findAllAttendees();
    public void insert(Attendee attendee);
    public void update(Attendee attendee);
    public void delete(Attendee attendee);
}
