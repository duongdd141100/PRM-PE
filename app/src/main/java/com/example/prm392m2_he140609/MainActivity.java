package com.example.prm392m2_he140609;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prm392m2_he140609.adapter.RoomAdapter;
import com.example.prm392m2_he140609.dao.RoomDAO;
import com.example.prm392m2_he140609.entity.Room;
import com.example.prm392m2_he140609.room.DBRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rooms = new ArrayList<>();
        RoomDAO roomDAO = DBRoomDatabase.getInstance(this).roomDao();
        rooms = roomDAO.findAll();

        RecyclerView recyclerView = findViewById(R.id.roomRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RoomAdapter wordAdapter = new RoomAdapter(rooms, this);
        recyclerView.setAdapter(wordAdapter);


        Button button = findViewById(R.id.btn_create);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateHourseActivity.class);
                startActivity(intent);
            }
        });


    }
}