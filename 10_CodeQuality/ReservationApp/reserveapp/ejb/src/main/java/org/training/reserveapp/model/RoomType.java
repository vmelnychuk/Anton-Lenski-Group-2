package org.training.reserveapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomTypeId;
    private String name;
    private long price;
    private long quantity;
    
    public RoomType(String name, long price) {
        this.name = name;
        this.price = price;
    }
    public RoomType(long id, String name, long price, long quantity) {
        this.roomTypeId = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public RoomType(long id) {
        
    }
    
    public RoomType() {
        
    }
    
    public long getRoomTypeId() {
        return roomTypeId;
    }
    public void setRoomTypeId(long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
}
