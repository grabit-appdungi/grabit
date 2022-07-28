package com.example.grabit;

public class MainHabitDetailData {

    private String detail_time;
    private String detail_memo;

    public MainHabitDetailData(String detail_memo,String detail_time){
        this.detail_memo = detail_memo;
        this.detail_time = detail_time;
    }

    public String getDetail_time() { return detail_time; }

    public String getDetail_memo() {
        return detail_memo;
    }

    public void setDetail_time(String tp_time) { this.detail_time = detail_time; }

    public void setDetail_memo(String detail_memo) {
        this.detail_memo = detail_memo;
    }
}
