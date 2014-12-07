package org.training.reserveapp.model;

public class Attendee {
    private long attendeeId;
    private String firstName;
    private String lastName;
    private String email;
    
    public Attendee(long attendeeId, String firstName, String lastName, String email) {
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
}
