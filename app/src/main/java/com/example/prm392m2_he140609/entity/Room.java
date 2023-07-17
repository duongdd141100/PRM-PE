package com.example.prm392m2_he140609.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.intellij.lang.annotations.Identifier;

@Entity(tableName = "room")
public class Room {
    @PrimaryKey
    private Integer id;

    private String roomNo;

    private String guestName;

    private String type;

    private Double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Room(Integer id, String roomNo, String guestName, String type, Double price, String description) {
        this.id = id;
        this.roomNo = roomNo;
        this.guestName = guestName;
        this.type = type;
        this.price = price;
        this.description = description;
    }



}
