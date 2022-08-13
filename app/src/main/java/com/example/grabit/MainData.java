package com.example.grabit;

public class MainData {

    private String habit_name;
    private String habit_num;

    public MainData(String habit_name, String habit_num){
        this.habit_name = habit_name;
        this.habit_num = habit_num;
    }

    public void setHabit_name(String habit_name) {
        this.habit_name = habit_name;
    }

    public void setHabit_num(String habit_num) {
        this.habit_num = habit_num;
    }

    public String getHabit_name() {
        return habit_name;
    }

    public String getHabit_num() {
        return habit_num;
    }
}