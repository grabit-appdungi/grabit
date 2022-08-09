package com.example.grabit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivitySettingThemeBinding;

import org.w3c.dom.Text;

public class SettingThemeActivity extends AppCompatActivity {
    private ActivitySettingThemeBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingThemeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
