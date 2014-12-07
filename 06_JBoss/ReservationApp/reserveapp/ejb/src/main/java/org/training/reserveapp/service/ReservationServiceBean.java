package org.training.reserveapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.training.reserveapp.data.AttendeeDao;
import org.training.reserveapp.data.ReservationDao;
import org.training.reserveapp.data.RoomTypeDao;
import org.training.reserveapp.model.Reservation;

@Stateless
public class ReservationServiceBean implements ReservationService {

    @Inject
    private ReservationDao reservationDao;
    @Inject
    private AttendeeDao attendeeDao;
    @Inject
    private RoomTypeDao roomTypeDao;
    @Override
    public void add(Reservation reservation) {
        attendeeDao.insert(reservation.getAttendee());
        reservationDao.insert(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        reservationDao.update(reservation);
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
