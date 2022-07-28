package com.example.grabit;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivityHabitSettingBinding;

public class HabitSettingActivity extends AppCompatActivity {
    private ActivityHabitSettingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHabitSettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ToggleButton btn_toggle_mon = binding.btnToggleMon;
        ToggleButton btn_toggle_tue = binding.btnToggleTue;
        ToggleButton btn_toggle_wed = binding.btnToggleWed;
        ToggleButton btn_toggle_thu = binding.btnToggleThu;
        ToggleButton btn_toggle_fri = binding.btnToggleFri;
        ToggleButton btn_toggle_sat = binding.btnToggleSat;
        ToggleButton btn_toggle_sun = binding.btnToggleSun;

        btn_toggle_mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "월요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 월요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_tue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "화요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 화요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "수요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 수요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_thu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "목요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 목요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "금요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 금요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_sat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "토요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 토요일", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "일요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "낫 일요일", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
