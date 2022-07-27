package com.example.grabit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.grabit.databinding.ActivityCalenderHabitBinding;

public class CalenderHabitActivity extends AppCompatActivity {

    private @NonNull ActivityCalenderHabitBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalenderHabitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
