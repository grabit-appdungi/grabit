package com.example.grabit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.grabit.databinding.ActivityCalenderHabitBinding;
import com.google.android.material.navigation.NavigationView;

public class CalenderHabitActivity extends AppCompatActivity {

    private @NonNull ActivityCalenderHabitBinding binding;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderHabitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
    }
}
