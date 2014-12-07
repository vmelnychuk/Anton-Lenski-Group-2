package org.training.reserveapp.service;

import java.util.List;
import javax.ejb.Local;

import org.training.reserveapp.model.RoomType;

@Local
public interface RoomTypeService {
    void add(RoomType roomType);
    void update(RoomType roomType);
    void delete(RoomType roomType);
    RoomType get(RoomType roomType);
    List<RoomType>findAllRoomType();
}
