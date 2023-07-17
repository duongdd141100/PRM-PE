package com.example.prm392m2_he140609.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.prm392m2_he140609.dao.RoomDAO;

@Database(entities = {com.example.prm392m2_he140609.entity.Room.class}, version = 2)

public abstract class DBRoomDatabase extends RoomDatabase {

    public abstract RoomDAO roomDao();

    private static DBRoomDatabase INSTANCE = null;

    public static DBRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                DBRoomDatabase.class, "database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }
}
