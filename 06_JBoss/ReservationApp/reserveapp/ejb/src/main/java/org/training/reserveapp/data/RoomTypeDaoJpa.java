package org.training.reserveapp.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.training.reserveapp.model.RoomType;

public class RoomTypeDaoJpa implements RoomTypeDao {
    @PersistenceContext(unitName="primary")
    private EntityManager entityManager;

    @Override
    public void insert(RoomType roomType) {
        entityManager.persist(roomType);
    }

    @Override
    public void update(RoomType roomType) {
        entityManager.merge(roomType);
    }

    @Override
    public void delete(RoomType roomType) {
        RoomType room  = find(roomType);
        entityManager.remove(room);
    }
    
    @Override
    public List<RoomType> findAllRoomType() {
        TypedQuery<RoomType> query = entityManager.createQuery("SELECT roomType FROM RoomType roomType", RoomType.class);
        return query.getResultList();
    }

    @Override
    public RoomType find(RoomType roomType) {
        return entityManager.find(RoomType.class, roomType.getRoomTypeId());
    }

}
