package com.example.lla.mode.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lla.R;

public class SelectItemHolder extends RecyclerView.ViewHolder {
    private TextView title ;
    private TextView description;
    public SelectItemHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }
}
