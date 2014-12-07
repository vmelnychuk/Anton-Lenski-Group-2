package org.training.reserveapp.model;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;


public class Reservation {
    private Attendee attendee;
    private RoomType roomType;
    private DateTime checkInDate;
    private DateTime checkOutDate;
    private long cost;
    private ReservationStatus status;
    public Reservation(Attendee attendee, RoomType roomType, Date checkInDate,
            Date checkOutDate, ReservationStatus status) {
        this.attendee = attendee;
        this.roomType = roomType;
        this.checkInDate = new DateTime(checkInDate) ;
        this.checkOutDate = new DateTime(checkOutDate);
        this.status = status;
        calculateCost();
    }
    public Attendee getAttendee() {
        return attendee;
    }
    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public long getCost() {
        return cost;
    }
    public DateTime getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(DateTime checkInDate) {
        this.checkInDate = checkInDate;
        calculateCost();
    }
    public DateTime getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(DateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
        calculateCost();
    }
    public void setCost(long cost) {
        this.cost = cost;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    public void calculateCost() {
        Days days = Days.daysBetween(checkInDate, checkOutDate);
        setCost(days.getDays() * roomType.getPrice());
    }
}
