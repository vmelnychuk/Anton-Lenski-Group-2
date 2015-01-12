package org.training.reserveapp.service;

import java.util.List;

import javax.ejb.Local;

import org.training.reserveapp.model.Reservation;

@Local
public interface ReservationService {
    void add(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation get(Reservation reservation);
    List<Reservation>findAllReservation();
}
