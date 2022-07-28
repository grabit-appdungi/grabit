package com.example.grabit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivitySettingBinding;
import com.example.grabit.databinding.ActivitySettingThemeBinding;
import com.google.android.material.navigation.NavigationView;

public class SettingActivity extends AppCompatActivity {
    private ActivitySettingBinding binding;
    private NavigationView navigationView;
    TextView accountText;
    TextView alarmText;
    TextView themeText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navigationView = binding.nav;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        Intent intent_home = new Intent(SettingActivity.this, MainActivity.class);
                        startActivity(intent_home);
                        break;
                    case R.id.item_habit:
                        Intent intent_main = new Intent(SettingActivity.this, HabitSettingActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.item_calender:
                        Intent intent_calender = new Intent(SettingActivity.this, CalenderActivity.class);
                        startActivity(intent_calender);
                        break;
                    case R.id.item_setting:
                        Intent intent_setting = new Intent(SettingActivity.this, SettingActivity.class);
                        startActivity(intent_setting);
                        break;
                }
                return false;
            }
        });

        accountText = binding.txtSettingAccount;
        alarmText = binding.txtSettingAlarm;
        themeText = binding.txtSettingTheme;

        accountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_account = new Intent(SettingActivity.this,SettingAccountActivity.class);
                startActivity(intent_account);
            }
        });

        alarmText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_alarm = new Intent(SettingActivity.this,SettingAlarmActivity.class);
                startActivity(intent_alarm);
            }
        });

        themeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_theme = new Intent(SettingActivity.this,SettingThemeActivity.class);
                startActivity(intent_theme);
            }
        });
    }
}
