package com.example.grabit;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivitySettingThemeBinding;

public class SettingThemeActivity extends AppCompatActivity {
    private ActivitySettingThemeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingThemeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
