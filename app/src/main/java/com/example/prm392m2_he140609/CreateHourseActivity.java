package com.example.prm392m2_he140609;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prm392m2_he140609.dao.RoomDAO;
import com.example.prm392m2_he140609.entity.Room;
import com.example.prm392m2_he140609.room.DBRoomDatabase;

import java.util.Arrays;

public class CreateHourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hourse);
        RoomDAO roomDAO = DBRoomDatabase.getInstance(this).roomDao();
        Button button = findViewById(R.id.btn_save);
        EditText roomNo = findViewById(R.id.et_room_no);
        EditText name = findViewById(R.id.et_guest_name);
        EditText price = findViewById(R.id.et_price);
        EditText description = findViewById(R.id.et_description);
        Spinner typeSpinner = findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomNo.getText().length() > 10
                || name.getText().length() > 50
                || price.getText().toString().length() > 5
                || description.getText().length() > 100
                || priceIsNotNumber(price.getText().toString())) {
                    Toast.makeText(CreateHourseActivity.this, "Invalid Input! Please enter again!", Toast.LENGTH_SHORT).show();
                }
                Room room = new Room(null, roomNo.getText().toString(), name.getText().toString(), typeSpinner.getSelectedItem().toString(), Double.parseDouble(String.valueOf(price.getText())), description.getText().toString());
                roomDAO.insert(Arrays.asList(room));
                Toast.makeText(CreateHourseActivity.this, "Save Successfully!", Toast.LENGTH_SHORT).show();
                roomNo.setText("");
                name.setText("");
                price.setText("");
                description.setText("");
                typeSpinner.setSelection(0);
            }
        });
    }

    private boolean priceIsNotNumber(String priceStr) {
        try {
            Double price = Double.parseDouble(priceStr);
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}