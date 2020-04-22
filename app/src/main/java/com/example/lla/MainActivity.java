package com.example.lla;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lla.common.Common;
import com.example.lla.common.LLA;
import com.example.lla.common.List;

/**
 * 메인엑티비티로써 변수를 유지한다.
 * */
public class MainActivity extends AppCompatActivity {
    private int ExceptionCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LLA.setPresentActivity(this);
        LLA.setPresentFragment(List.Fragment.Main);

        refreshFragment();
    }

    public void refreshFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, LLA.createPresentFragment()).commit();
        ExceptionCount = 0;
    }
    public void refreshFragmentWithException() {
        if(ExceptionCount > 5){
            finish();
        }
        ExceptionCount++;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment, LLA.createPresentFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        Common.finishIn2SecondsOfMain(System.currentTimeMillis(), this);
        refreshFragment();
    }
}
