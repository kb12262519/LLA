package com.example.lla.mode.holder;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lla.R;
import com.example.lla.common.Common;
import com.example.lla.common.LLA;
import com.example.lla.common.List;

public class SelectItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView title ;
    private TextView description;
    private List.gameFragment gameFragment;

    public SelectItemHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        title.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Common.toastShort(LLA.getPresentActivity().getApplicationContext(), "test" + gameFragment.name());
        }catch (Exception e){
            Log.d("?!?!", e.toString());
        }
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

    public List.gameFragment getGameFragment() {
        return gameFragment;
    }

    public void setGameFragment(List.gameFragment gameFragment) {
        this.gameFragment = gameFragment;
    }
}
