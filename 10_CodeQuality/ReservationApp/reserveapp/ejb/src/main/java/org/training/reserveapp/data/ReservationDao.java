package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.Reservation;


public interface ReservationDao {
    List<Reservation>findAllReservations();
    void insert(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findReservation(Reservation reservation);
}
