package com.lol6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MySimpleArrayAdapter extends ArrayAdapter<Champion> {
  private final Context context;
  private ArrayList<Champion> values;

  public MySimpleArrayAdapter(Context context, ArrayList<Champion> values) {
    super(context, R.layout.rowlayout, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
    TextView textView1 = (TextView) rowView.findViewById(R.id.firstLine);
    TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

    Champion ch = values.get(position);
    textView1.setText(ch.champion);
    textView2.setText("Win rate : " +  String.format("%.1f",ch.rate*100) + "%   " + "Count : " + ch.count);

    int j = MainActivity.images[MainActivity.champion.indexOf(ch.champion)];
    imageView.setImageResource(j);


    return rowView;
  }
} 