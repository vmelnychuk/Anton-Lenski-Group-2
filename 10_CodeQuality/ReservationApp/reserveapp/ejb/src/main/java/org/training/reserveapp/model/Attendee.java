package org.training.reserveapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendeeId;
    private String firstName;
    private String lastName;
    private String email;
    
    public Attendee() {
        
    }
    public Attendee(long attendeeId, String firstName, 
            String lastName, String email) {
        this.attendeeId = attendeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Attendee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public long getAttendeeId() {
        return attendeeId;
    }
    public void setAttendeeId(long attendeeId) {
        this.attendeeId = attendeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Attendee [attendeeId=" + attendeeId + ", firstName="
                + firstName + ", lastName=" + lastName + ", email=" + email
                + "]";
    }
}
