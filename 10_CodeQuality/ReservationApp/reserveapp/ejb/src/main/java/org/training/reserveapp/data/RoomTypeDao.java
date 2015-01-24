package org.training.reserveapp.data;

import java.util.List;

import org.training.reserveapp.model.RoomType;


public interface RoomTypeDao {
    public List<RoomType>findAllRoomType();
    public RoomType find(RoomType roomType);
    public void insert(RoomType roomType);
    public void update(RoomType roomType);
    public void delete(RoomType roomType);
}
