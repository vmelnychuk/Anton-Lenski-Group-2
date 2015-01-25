package org.training.reserveapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.training.reserveapp.data.RoomTypeDao;
import org.training.reserveapp.model.RoomType;


//@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class RoomTypeServiceBean implements RoomTypeService {
    @Inject
    private RoomTypeDao roomTypeDao;
    
    public void add(RoomType roomType) {
        roomTypeDao.insert(roomType);
    }
    
    public void update(RoomType roomType) {
        roomTypeDao.update(roomType);
    }
    
    
    public void delete(RoomType roomType) {
        roomTypeDao.delete(roomType);
    }
    
    public List<RoomType> findAllRoomType() {
        return roomTypeDao.findAllRoomType();
    }
    
    public RoomType get(RoomType roomType) {
        return roomTypeDao.find(roomType);
    }
}
