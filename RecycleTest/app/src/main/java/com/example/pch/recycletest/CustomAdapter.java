package com.example.pch.recycletest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> mList;
    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        public CustomViewHolder(View view){
            super(view);
            text = view.findViewById(R.id.something);
        }
    }

    public CustomAdapter(ArrayList<String> list){
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.test_item2,viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder customViewHolder, int i) {
        if(customViewHolder instanceof CustomViewHolder) {
            ((CustomViewHolder)customViewHolder).text.setText(mList.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
