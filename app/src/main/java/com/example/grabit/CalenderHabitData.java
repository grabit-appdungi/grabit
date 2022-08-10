package com.example.grabit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

// 날짜별 습관 정보 기록.
// date 함수, YYYY-MM-DD 문자열 입력받기


public class CalenderHabitData {

    private String timeString;
    private String achieve_percent;

    public MainData(String timeString, String achieve_percent){
        this.timeString = timeString;
        this.achieve_percent = achieve_percent;
    }

    public void SetTimeString(String timeString) {
        this.timeString = timeString;
    }

    public void SetAchieve_percent(String achieve_percent) {
        this.achieve_percent = achieve_percent;
    }

    public String getTimeString() {
        return timeString;
    }

    public String getAchieve_percent() {
        return achieve_percent;
    }
}

