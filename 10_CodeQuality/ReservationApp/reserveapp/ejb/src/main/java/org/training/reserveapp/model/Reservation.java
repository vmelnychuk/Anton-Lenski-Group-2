package org.training.reserveapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;
import org.joda.time.Days;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "attendeeId")
    private Attendee attendee;
    @ManyToOne
    @JoinColumn(name = "roomTypeId")
    private RoomType roomType;
    private Date checkInDate;
    private Date checkOutDate;
    private long cost;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    public Reservation() {
        
    }
    public Reservation(Attendee attendee, RoomType roomType, Date checkInDate,
            Date checkOutDate, ReservationStatus status) {
        this.attendee = attendee;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        calculateCost();
    }
    public long getReservationId() {
        return reservationId;
    }
    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
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
    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
        calculateCost();
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
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
        Days days = Days.daysBetween(new DateTime(checkInDate), new DateTime(checkOutDate));
        setCost(days.getDays() * roomType.getPrice());
    }
}
