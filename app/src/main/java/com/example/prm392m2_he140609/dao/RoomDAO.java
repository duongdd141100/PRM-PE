package com.example.prm392m2_he140609.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm392m2_he140609.entity.Room;

import java.util.List;

@Dao
public interface RoomDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Room> rooms);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Room room);

    @Query("select * from room order by price ASC")
    List<Room> findAll();

    @Query("select * from room where id = :id")
    List<Room> findById(Integer id);

}
