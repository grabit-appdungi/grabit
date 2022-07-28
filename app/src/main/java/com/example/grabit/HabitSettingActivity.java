package com.example.grabit;

import android.os.Bundle;

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
    }
}
