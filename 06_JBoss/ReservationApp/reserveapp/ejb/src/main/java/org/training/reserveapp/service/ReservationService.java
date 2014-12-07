package org.training.reserveapp.service;

import java.util.List;

import org.training.reserveapp.model.Reservation;

public interface ReservationService {
    void add(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation get(Reservation reservation);
    List<Reservation>findAllReservation();
}
