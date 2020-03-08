package com.example.lla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lla.common.Const;
import com.example.lla.common.LLA;
import com.example.lla.common.MainMenuFragment;
import com.example.lla.option.OptionFragment;
import com.example.lla.random.RandomFragment;
import com.example.lla.select.SelectFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LLA.presentFragment = LLA.presentFragment==null? Const.Fragment.Main : LLA.presentFragment;

        changeFragment();
    }

    public void changeFragment(){
        Fragment f = new MainMenuFragment();
        if(LLA.presentFragment == Const.Fragment.Random) f = new RandomFragment();
        else if(LLA.presentFragment == Const.Fragment.Select) f = new SelectFragment();
        else if(LLA.presentFragment == Const.Fragment.Option) f = new OptionFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.mainFragment, f);
        fragmentTransaction.commit();
    }
}
