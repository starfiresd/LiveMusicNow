package com.example.livemusicnowapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.SQLException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        initHomeButton();
        initEventButton();
        initMapButton();
        initSettingsButton();
        EventsDataSource ds = new EventsDataSource(this);
        ArrayList<String> bands;
        try {
            ds.open();
            bands = ds.getEventBand();
            ds.close();
            RecyclerView bandList = findViewById(R.id.rvBands);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            bandList.setLayoutManager(layoutManager);
            EventAdapter eventAdapter = new EventAdapter(bands);
            bandList.setAdapter(eventAdapter);
        } catch (SQLException e) {
            Toast.makeText(this, "Error retrieving bands", Toast.LENGTH_LONG).show();
        }
    }
    private void initHomeButton(){
        Button button = findViewById(R.id.btn_main_home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventListActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initEventButton(){
        Button button = findViewById(R.id.btn_main_event);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventListActivity.this, EventActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initMapButton(){
        Button button = findViewById(R.id.btn_main_map);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventListActivity.this, MapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    private void initSettingsButton(){
        Button button = findViewById(R.id.btn_main_settings);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventListActivity.this, SettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}