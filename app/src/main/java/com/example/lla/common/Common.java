package com.example.lla.common;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * 다른 어플리케이션에서도 사용 할 수 있음
 * */
public class Common {

    public static void toastLong(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**메인 액티비티에서 뒤로가기 두 번 누르면 종료*/
    public static void finishIn2SecondsOfMain(long now, Activity activity) {
        if (now > LLA.getBackpressedTime() + 2000 && LLA.getPresentFragment() == List.Fragment.Main) {
            LLA.setBackpressedTime(now);
            Common.toastShort(activity, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.");
        } else if (now <= LLA.getBackpressedTime() + 2000) {
            activity.finish();
        } else
            LLA.setPresentFragment(List.Fragment.Main);
    }
}
