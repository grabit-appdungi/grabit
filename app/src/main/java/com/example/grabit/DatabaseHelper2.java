//package com.example.grabit;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//// 테이블2, 습관 달성 기록하는 테이블
//
//public class DatabaseHelper2 extends SQLiteOpenHelper {
//    // If you change the database schema, you must increment the database version.
//    public static final int DATABASE_VERSION = 2;
//    public static final String DATABASE_NAME = "Achieve_habit.db";
//
//    // columns
//    public static final String TABLE_NAME = "HABIT_RECODE";
//    public static final String HABIT_NAME = "habit_name";
//    public static final String ACHIEVE_DATE = "achieve_date";
//    public static final String ACHIEVE_TIME = "achieve_time";
//    public static final String HABIT_MEMO = "habit_memo";
//
//
//    public static final String[] ALL_COLUMNS2 = {HABIT_NAME, ACHIEVE_DATE, ACHIEVE_TIME, HABIT_MEMO};
//
//    // 테이블 생성문
//    private static final String CREATE_TABLE =
//            "create table " + TABLE_NAME + "(" +
//                    HABIT_NAME + "String primary key autoincrement, " +
//                    ACHIEVE_DATE + " integer, " +
//                    ACHIEVE_TIME + " integer, " +
//                    HABIT_MEMO + "text " +
//                    ")";
//
//    // 데이터베이스 생성
//    public DatabaseHelper2(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // 테이블 생성
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE);
//    }
//
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        onUpgrade(db, oldVersion, newVersion);
//    }
//
//}