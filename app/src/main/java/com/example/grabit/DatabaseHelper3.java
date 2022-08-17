//package com.example.grabit;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//// 테이블3, 계정정보, 알림설정
//
//public class DatabaseHelper3 extends SQLiteOpenHelper {
//    // If you change the database schema, you must increment the database version.
//    public static final int DATABASE_VERSION = 3;
//    public static final String DATABASE_NAME = "Achieve_habit.db";
//
//    // columns
//    public static final String TABLE_NAME = "ACCOUNT_ALARM";
//    public static final String USER_NAME = "user_name";
//    public static final String USER_MAIL = "user_mail";
//    public static final String USER_PASSWORD = "user_password";
//    public static final String ALARM_SOUND = "alarm_sound";
//    public static final String ALARM_VIBRATING = "alarm_vibrating";
//    public static final String ALARM_MUTE = "alarm_mute";
//    public static final String PROFILE_IMAGE = "profile_image";
//
//    public static final String[] ALL_COLUMNS3 = {TABLE_NAME, USER_NAME, USER_MAIL, USER_PASSWORD, ALARM_SOUND, ALARM_VIBRATING, ALARM_MUTE, PROFILE_IMAGE};
//
//    // 테이블 생성문
//    private static final String CREATE_TABLE =
//            "create table " + TABLE_NAME + "(" +
//                    USER_NAME + "String primary key autoincrement, " +
//                    USER_MAIL + " String, " +
//                    USER_PASSWORD + " Stirng, " +
//                    ALARM_SOUND + " Integer, " +
//                    ALARM_VIBRATING + " Integer, " +
//                    ALARM_MUTE + " Integer, " +
//                    PROFILE_IMAGE + "Blob" +
//                    ")";
//
//    // 데이터베이스 생성
//    public DatabaseHelper3(Context context) {
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