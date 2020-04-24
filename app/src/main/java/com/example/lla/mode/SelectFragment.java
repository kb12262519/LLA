package com.example.lla.mode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lla.MainActivity;
import com.example.lla.R;
import com.example.lla.common.Const;
import com.example.lla.common.List;
import com.example.lla.mode.adapter.SelectItemAdapter;
import com.example.lla.mode.model.SelectItem;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Objects;

/**
 *게임을 선택하는 화면 RecyclerView로 표현
 * 추후에 그냥 리스트 형식도 만들어 볼 생각
 * */
public class SelectFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.select, container, false);

        ArrayList<SelectItem> selectItemList = new ArrayList<>();

        setSelectItemList(selectItemList);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        SelectItemAdapter adapter = new SelectItemAdapter(selectItemList);
        recyclerView.setAdapter(adapter);


        return rootView;
    }

    private void setSelectItemList(ArrayList<SelectItem> list) {
        try {
            XmlPullParser xpp = getResources().getXml(R.xml.description);

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType() == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals(Const.XML_GAME)) {
                        list.add(new SelectItem(xpp.getAttributeValue(null, Const.XML_NAME), getGameFragment(xpp.getAttributeValue(null, Const.XML_FRAGMENT)),xpp.nextText()));
                    }
                }
                xpp.next();
            }
        } catch (Exception e) {
            ((MainActivity) Objects.requireNonNull(getActivity())).refreshFragmentWithException();
        }
    }

    private List.gameFragment getGameFragment(String str){
        if(List.gameFragment.LiarGame.name().equals(str)){
            return List.gameFragment.LiarGame;
        }else if(List.gameFragment.UpAndDown.name().equals(str)){
            return List.gameFragment.UpAndDown;
        }
        return List.gameFragment.Else;
    }
}
