package org.training.reserveapp.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.training.reserveapp.model.Attendee;


public class AttendeeDaoJpa implements AttendeeDao {
    @PersistenceContext(unitName="primary")
    private EntityManager entityManager;
    
    @Override
    public List<Attendee> findAllAttendees() {
        TypedQuery<Attendee> query = entityManager.createQuery("SELECT attendee FROM Attendee attendee", Attendee.class);
        return query.getResultList();
    }

    @Override
    public void insert(Attendee attendee) {
        entityManager.persist(attendee);
    }

    @Override
    public void update(Attendee attendee) {
        entityManager.merge(attendee);
    }

    @Override
    public void delete(Attendee attendee) {
        entityManager.remove(attendee);
    }

}
