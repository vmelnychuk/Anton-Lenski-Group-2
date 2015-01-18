package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.Reservation;


public interface ReservationDao {
    public List<Reservation>findAllReservations();
    public void insert(Reservation reservation);
    public void update(Reservation reservation);
    public void delete(Reservation reservation);
    public Reservation findReservation(Reservation reservation);
}
