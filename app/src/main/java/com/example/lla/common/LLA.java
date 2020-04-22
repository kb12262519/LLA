package com.example.lla.common;

import android.app.Activity;

import com.example.lla.MainActivity;
import com.example.lla.mode.RandomFragment;
import com.example.lla.mode.SelectFragment;
import com.example.lla.option.OptionFragment;

/**
 * LLA에서만 사용
 * */
public class LLA {

    /*변수*/

    /*현재의 Fragment나 게임 저장*/
    private static List.Fragment PresentFragment;
    private static List.Game PresentGame = List.Game.LiarGame;

    private static List.Game[] GAMES = List.Game.values();

    private static long backpressedTime = 0;

    //메인 액티비티를 유지
    private static Activity presentActivity = null;

    /*메소드*/

    public static void nextGame() {
        PresentGame = GAMES[(PresentGame.ordinal() + 1) % GAMES.length];
    }

    public static void previousGame() {
        PresentGame = GAMES[(PresentGame.ordinal() - 1 + GAMES.length) % GAMES.length];
    }

    public static androidx.fragment.app.Fragment createPresentFragment() {
        if (LLA.getPresentFragment() == List.Fragment.Random) return new RandomFragment();
        else if (LLA.getPresentFragment() == List.Fragment.Select) return new SelectFragment();
        else if (LLA.getPresentFragment() == List.Fragment.Option) return new OptionFragment();
        else return new MainMenuFragment();
    }
    public static void refreshFragment() {
        if((presentActivity != null) && (presentActivity instanceof MainActivity)){
            ((MainActivity) presentActivity).refreshFragment();
        }
    }
    public static void toastAndFinish(String str){
        Common.toastLong(presentActivity, str==null?"에러가 발생했습니다.":str);
    }

    /*getter and setter*/

    public static List.Fragment getPresentFragment() {
        return PresentFragment;
    }

    public static void setPresentFragment(List.Fragment presentFragment) {
        LLA.PresentFragment = presentFragment;
    }

    public static List.Game getPresentGame() {
        return PresentGame;
    }

    public static void setPresentGame(List.Game presentGame) {
        LLA.PresentGame = presentGame;
    }

    public static long getBackpressedTime() {
        return backpressedTime;
    }

    public static void setBackpressedTime(long backpressedTime) {
        LLA.backpressedTime = backpressedTime;
    }

    public static Activity getPresentActivity() {
        return presentActivity;
    }

    public static void setPresentActivity(Activity presentActivity) {
        LLA.presentActivity = presentActivity;
    }

}
