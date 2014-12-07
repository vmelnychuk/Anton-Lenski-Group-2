package org.training.reserveapp.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.training.reserveapp.model.Reservation;

public class ReservationDaoJpa implements ReservationDao {
    @PersistenceContext(unitName="primary")
    private EntityManager entityManager;
    
    @Override
    public Reservation findReservation(Reservation reservation) {
        return entityManager.find(Reservation.class, reservation.getReservationId());
    }

    @Override
    public List<Reservation> findAllReservations() {
        TypedQuery<Reservation> query = entityManager.createQuery("SELECT reservation FROM Reservation reservation", Reservation.class);
        return query.getResultList();
    }

    @Override
    public void insert(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        entityManager.merge(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        entityManager.remove(reservation);
    }

}
