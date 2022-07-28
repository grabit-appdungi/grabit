package com.example.grabit;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grabit.databinding.ActivitySettingAlarmBinding;

public class SettingAlarmActivity extends AppCompatActivity {
    private ActivitySettingAlarmBinding binding;
    TextView startTextView;
    TextView finishTextView;
    Switch disturbSwc;
    LinearLayout disturbTxts;
    Button disturbBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingAlarmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startTextView = binding.txtStart;
        finishTextView = binding.txtFinish;
        disturbSwc = binding.swc;
        disturbTxts = binding.txtsDisturbSetting;
        disturbBtn = binding.btnConfirm;

        startTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog startDialog = new TimePickerDialog(SettingAlarmActivity.this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int startH, int startM) {
                        startTextView.setText(String.format("%02d:%02d",startH,startM));
                    }
                }, 15, 24, true);
                startDialog.setTitle("시작 시간 설정");
                startDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                startDialog.show();
            }
        });

        finishTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog finishDialog = new TimePickerDialog(SettingAlarmActivity.this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int finishH, int finishM) {
                        finishTextView.setText(String.format("%02d:%02d",finishH,finishM));
                    }
                }, 15, 24, true);
                finishDialog.setTitle("종료 시간 설정");
                finishDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                finishDialog.show();
            }
        });
        if(disturbSwc.isChecked()){
            disturbTxts.setVisibility(View.VISIBLE);
            disturbBtn.setVisibility(View.VISIBLE);
        }
        else{
            disturbTxts.setVisibility(View.INVISIBLE);
            disturbBtn.setVisibility(View.INVISIBLE);
        }

        disturbSwc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(disturbSwc.isChecked()){
                    disturbTxts.setVisibility(View.VISIBLE);
                    disturbBtn.setVisibility(View.VISIBLE);
                }
                else{
                    disturbTxts.setVisibility(View.INVISIBLE);
                    disturbBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

    }//onCreat
}
