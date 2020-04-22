package com.example.lla.mode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lla.R;
import com.example.lla.mode.model.SelectItem;
import com.example.lla.mode.holder.SelectItemHolder;

import java.util.ArrayList;

public class SelectItemAdapter extends RecyclerView.Adapter<SelectItemHolder> {

    private ArrayList<SelectItem> selectItemList;

    public SelectItemAdapter(ArrayList<SelectItem> selectItemList){
        this.selectItemList = selectItemList;
    }
    @NonNull
    @Override
    public SelectItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.select_item, parent, false);
        SelectItemHolder holder = new SelectItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectItemHolder holder, int position) {
        SelectItem item = selectItemList.get(position);
        holder.getTitle().setText(item.getTitle());
        holder.getDescription().setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return selectItemList.size();
    }
}
