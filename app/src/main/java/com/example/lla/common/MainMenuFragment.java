package com.example.lla.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lla.MainActivity;
import com.example.lla.R;

import java.util.Objects;
/**
 * 어떤 메뉴(프래그먼트)를 선택하여 띄워 줄 건지 선택
 * */
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
                LLA.setPresentFragment(List.Fragment.Random);
                break;
            case R.id.select:
                LLA.setPresentFragment(List.Fragment.Select);
                break;
            case R.id.option:
                LLA.setPresentFragment(List.Fragment.Option);
                break;
            case R.id.quit:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
        LLA.refreshFragment();
    }
}
