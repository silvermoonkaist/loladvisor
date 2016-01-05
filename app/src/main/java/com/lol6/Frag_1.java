package com.lol6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Frag_1 extends Fragment {
    public ListView lv;
    public static MySimpleArrayAdapter adapter1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_frag, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView);


        adapter1 = new MySimpleArrayAdapter(getContext(), LVMonitor.mostPick);
        lv.setAdapter(adapter1);
        //adapter1.notifyDataSetChanged();

        return rootView;
    }
}

