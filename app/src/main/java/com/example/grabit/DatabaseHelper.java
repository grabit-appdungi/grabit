package com.example.grabit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Grabit.db";

    // columns
    public static final String TABLE_NAME = "HABIT_SETTING";
    public static final String HABIT_NAME = "habit_name";
    public static final String PERIOD = "period";
    public static final String ALARM_TIME = "alarm_time";
    public static final String HABIT_MEMO = "habit_memo";

    public static final String[] ALL_COLUMNS = {HABIT_NAME, PERIOD, ALARM_TIME, HABIT_MEMO};

    // 테이블 생성문
    private static final String CREATE_TABLE =
            "create table " + TABLE_NAME + "(" +
                    HABIT_NAME + "Interger primary key autoincrement, " +
                    PERIOD + " text, " +
                    ALARM_TIME + " integer, " +
                    HABIT_MEMO + " text" +
            ")";

    // 데이터베이스 생성
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 테이블 생성
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}