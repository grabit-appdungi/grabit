package com.example.grabit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grabit.databinding.ActivityMainHabitDetailBinding;
import com.google.android.material.navigation.NavigationView;

import java.sql.Time;
import java.util.ArrayList;

public class MainHabitDetailActivity extends AppCompatActivity {

    private @NonNull ActivityMainHabitDetailBinding binding;
    private ArrayList<MainHabitDetailData> arrayList;
    private MainHabitDetailAdapter mainHabitDetailAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NavigationView navigationView;
    private TimePicker timePicker;
    MainHabitDetailData mainHabitDetailData;
    Button buttonWrite;
    String time;
    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainHabitDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navigationView = binding.nav;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        Intent intent_home = new Intent(MainHabitDetailActivity.this, MainActivity.class);
                        startActivity(intent_home);
                        break;
                    case R.id.item_habit:
                        Intent intent_main = new Intent(MainHabitDetailActivity.this, HabitSettingActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.item_calender:
                        Intent intent_calender = new Intent(MainHabitDetailActivity.this, CalenderActivity.class);
                        startActivity(intent_calender);
                        break;
                    case R.id.item_setting:
                        Intent intent_setting = new Intent(MainHabitDetailActivity.this, SettingActivity.class);
                        startActivity(intent_setting);
                        break;
                }
                return false;
            }
        });

        recyclerView = binding.rcviewHabitDetail;
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainHabitDetailAdapter = new MainHabitDetailAdapter(arrayList);
        recyclerView.setAdapter(mainHabitDetailAdapter);

        timePicker = binding.tpHabitDetail;
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                time = String.format("%02d:%02d",hour,min);
            }
        });

        buttonWrite = binding.btnHabitDetailWrite;
        buttonWrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                memo = binding.etxtHabitDetail.getText().toString();
                mainHabitDetailData = new MainHabitDetailData(memo,time);
                arrayList.add(mainHabitDetailData);
                mainHabitDetailAdapter.notifyDataSetChanged();
            }
        });

        Button btn_edit = binding.btnEdit;
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHabitDetailActivity.this, HabitSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
