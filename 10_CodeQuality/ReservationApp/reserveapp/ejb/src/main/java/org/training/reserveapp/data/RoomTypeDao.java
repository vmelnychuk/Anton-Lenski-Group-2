package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.RoomType;


public interface RoomTypeDao {
    List<RoomType>findAllRoomType();
    RoomType find(RoomType roomType);
    void insert(RoomType roomType);
    void update(RoomType roomType);
    void delete(RoomType roomType);
}
