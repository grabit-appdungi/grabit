package com.example.grabit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainHabitDetailAdapter extends RecyclerView.Adapter<MainHabitDetailAdapter.CustomViewHolder> {

    private ArrayList<MainHabitDetailData> arrayList;
    private Intent intent;

    public MainHabitDetailAdapter(ArrayList<MainHabitDetailData> arrayList) { this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainHabitDetailAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_llist_main_habit_detail,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainHabitDetailAdapter.CustomViewHolder holder, int position) {
        holder.detail_time.setText(arrayList.get(position).getDetail_time());
        holder.detail_memo.setText(arrayList.get(position).getDetail_memo());

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView detail_time;
        protected TextView detail_memo;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.detail_time = (TextView) itemView.findViewById(R.id.txt_list_time);
            this.detail_memo = (TextView) itemView.findViewById(R.id.txt_list_memo);
        }
    }
}
