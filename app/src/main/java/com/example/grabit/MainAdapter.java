package com.example.grabit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<DatabaseHelper> arrayList;
    private Intent intent;

    public MainAdapter(ArrayList<DatabaseHelper> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_main,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.habit_name.setText(arrayList.get(position).getHabit_name());
        holder.habit_num.setText(arrayList.get(position).getHabit_num());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), MainHabitDetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView habit_name;
        protected TextView habit_num;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.habit_name = (TextView) itemView.findViewById(R.id.txt_list_habit_name);
            this.habit_num = (TextView) itemView.findViewById(R.id.txt_list_habit_pernum);
        }
    }
}
