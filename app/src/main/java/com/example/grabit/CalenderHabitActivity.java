package com.example.grabit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.grabit.databinding.ActivityCalenderHabitBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class CalenderHabitActivity extends AppCompatActivity {

    private @NonNull ActivityCalenderHabitBinding binding;
    private NavigationView navigationView;
    private ArrayList<String> arrayList;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderHabitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList = new ArrayList<>();
        arrayList.add("전체");
        arrayList.add("습관1");
        arrayList.add("습관2");

        spinner = binding.spnHabit;
        navigationView = binding.nav;


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        Intent intent_home = new Intent(CalenderHabitActivity.this, MainActivity.class);
                        startActivity(intent_home);
                        break;
                    case R.id.item_habit:
                        Intent intent_main = new Intent(CalenderHabitActivity.this, HabitSettingActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.item_calender:
                        Intent intent_calender = new Intent(CalenderHabitActivity.this, CalenderActivity.class);
                        startActivity(intent_calender);
                        break;
                    case R.id.item_setting:
                        Intent intent_setting = new Intent(CalenderHabitActivity.this, SettingActivity.class);
                        startActivity(intent_setting);
                        break;
                }
                return false;
            }
        });

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner.setAdapter(arrayAdapter);
        Intent intent = new Intent(this.getIntent());
        int selection = intent.getIntExtra("selection",1);
        spinner.setSelection(selection, false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(arrayList.get(position)=="전체"){
                    Intent intent_whole = new Intent(CalenderHabitActivity.this,CalenderActivity.class);
                    startActivity(intent_whole);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
