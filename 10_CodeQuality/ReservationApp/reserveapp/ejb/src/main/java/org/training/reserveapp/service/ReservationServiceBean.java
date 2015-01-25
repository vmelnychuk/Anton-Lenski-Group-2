package org.training.reserveapp.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;


import org.training.reserveapp.data.ReservationDao;
import org.training.reserveapp.model.Reservation;

@Stateless
public class ReservationServiceBean implements ReservationService {

    @Inject
    private ReservationDao reservationDao;

    @EJB
    private EmailService emailService;
    @Override
    public void add(Reservation reservation) {
        reservationDao.insert(reservation);
        emailService.composeMail(reservation.getAttendee());
    }

    @Override
    public void update(Reservation reservation) {
        reservationDao.update(reservation);
        emailService.composeMail(reservation.getAttendee());
    }

    @Override
    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);
    }

    @Override
    public Reservation get(Reservation reservation) {
        return reservationDao.findReservation(reservation);
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationDao.findAllReservations();
    }
}
