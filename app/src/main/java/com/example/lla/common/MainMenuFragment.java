package com.example.lla.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lla.R;

public class MainMenuFragment extends Fragment implements View.OnClickListener {
    public MainMenuFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_menu, container, false);
        setListener(v);
        return v;
    }

    private void setListener(View v) {
        v.findViewById(R.id.random).setOnClickListener(this);
        v.findViewById(R.id.select).setOnClickListener(this);
        v.findViewById(R.id.option).setOnClickListener(this);
        v.findViewById(R.id.quit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.random:
                LLA.presentFragment = Const.Fragment.Random;
                break;
            case R.id.select:
                LLA.presentFragment = Const.Fragment.Select;
                break;
            case R.id.option:
                LLA.presentFragment = Const.Fragment.Option;
                break;
            case R.id.quit:
                Toast.makeText(getContext(), "?", Toast.LENGTH_SHORT).show();
//                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }
}
