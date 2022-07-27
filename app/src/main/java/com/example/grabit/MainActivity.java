package com.example.grabit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.grabit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    TextView dateText;
    int progress;

    DatePickerDialog datePickerDialog;
    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.rcviewMain;
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        arrayList.add(new MainData("물 마시기","40"));
        arrayList.add(new MainData("걷기","80"));
        arrayList.add(new MainData("아침밥 먹기","100"));
        arrayList.add(new MainData("독서하기","45"));
        arrayList.add(new MainData("아침에 일어나기","0"));
        arrayList.add(new MainData("스트레칭 하기","50"));
        arrayList.add(new MainData("영어공부 하기","20"));
        arrayList.add(new MainData("물 마시기","40"));
        arrayList.add(new MainData("걷기","80"));
        arrayList.add(new MainData("아침밥 먹기","100"));
        arrayList.add(new MainData("독서하기","45"));
        arrayList.add(new MainData("아침에 일어나기","0"));
        arrayList.add(new MainData("스트레칭 하기","50"));
        arrayList.add(new MainData("영어공부 하기","20"));

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        dateText = binding.txtDate;

        if(arrayList != null){
            int i = 0;
            progress = 0;
            while(i < arrayList.size()){
                progress = progress + Integer.parseInt(arrayList.get(i).getHabit_num().toString());
                i++;
            }
            progress = progress / arrayList.size() ;
        }
        ProgressBar progressBar = binding.pgbarMain;
        progressBar.setProgress(progress);
        binding.txtProgressNumber.setText(String.valueOf(progress));

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        m = m+1;
                        String date = y + "/" + m + "/" + d;

                        dateText.setText(date);
                    }
                },y,m,d);
                datePickerDialog.show();
            }
        });
    }

}