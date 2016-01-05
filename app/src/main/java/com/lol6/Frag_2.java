package com.lol6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Frag_2 extends Fragment {
    public ListView lv;
    public static MySimpleArrayAdapter adapter2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_frag, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView);


        adapter2 = new MySimpleArrayAdapter(getContext(), LVMonitor.mostWin);
        lv.setAdapter(adapter2);
        //adapter1.notifyDataSetChanged();

        return rootView;
    }
}