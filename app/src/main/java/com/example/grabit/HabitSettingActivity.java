package com.example.grabit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.grabit.databinding.ActivityHabitSettingBinding;
import com.example.grabit.databinding.ActivitySettingAccountBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

public class HabitSettingActivity extends AppCompatActivity {
    private ActivityHabitSettingBinding binding;
    private NavigationView navigationView;

    private Uri uri;
    private Bitmap bitmap;
    private ActivityResultLauncher<Intent> resultLauncher;

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

        navigationView = binding.nav;

        Switch swc_alarm = binding.swcAlarm;
        LinearLayout lnr_alarm = binding.lnrAlarm;
        Button btn_habit_confirm =  binding.btnHabitConfirm;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        Intent intent_home = new Intent(HabitSettingActivity.this, MainActivity.class);
                        startActivity(intent_home);
                        break;
                    case R.id.item_habit:
                        Intent intent_main = new Intent(HabitSettingActivity.this, HabitSettingActivity.class);
                        startActivity(intent_main);
                        break;
                    case R.id.item_calender:
                        Intent intent_calender = new Intent(HabitSettingActivity.this, CalenderActivity.class);
                        startActivity(intent_calender);
                        break;
                    case R.id.item_setting:
                        Intent intent_setting = new Intent(HabitSettingActivity.this, SettingActivity.class);
                        startActivity(intent_setting);
                        break;
                }
                return false;
            }
        });

        ImageView img_habit = binding.imgHabit;
        img_habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                resultLauncher.launch(intent);
            }
        });

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            uri = result.getData().getData();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                                img_habit.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        btn_toggle_mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "월요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "월요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_tue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "화요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "화요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "수요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "수요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_thu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "목요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "목요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "금요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "금요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_sat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "토요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "토요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_toggle_sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "일요일", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "일요일 해제", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(swc_alarm.isChecked()){
            lnr_alarm.setVisibility(View.VISIBLE);
        }
        else{
            lnr_alarm.setVisibility(View.INVISIBLE);
        }

        swc_alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swc_alarm.isChecked()){
                    lnr_alarm.setVisibility(View.VISIBLE);
                }
                else{
                    lnr_alarm.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_habit_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(HabitSettingActivity.this, MainActivity.class);
                startActivity(intent_home);
            }
        });

        btn_habit_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(HabitSettingActivity.this, MainActivity.class);
                startActivity(intent_home);
            }
        });
    }
}