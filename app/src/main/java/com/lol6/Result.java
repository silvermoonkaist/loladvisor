package com.lol6;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Result extends AppCompatActivity {
    String text_0 = "";
    String text_1 = "";
    String text_2 = "";
    String text_3 = "";
    String text_4 = "";
    String text_5 = "";
    String text_6 = "";
    String text_7 = "";
    String text_8 = "";
    String text_9 = "";
    String text_10 = "";
    String send_data;
    String receieve_data = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Search Result");



        Intent intent = getIntent();
        text_0 = intent.getExtras().getString("text_0");
        text_1 = intent.getExtras().getString("text_1");
        text_2 = intent.getExtras().getString("text_2");
        text_3 = intent.getExtras().getString("text_3");
        text_4 = intent.getExtras().getString("text_4");
        text_5 = intent.getExtras().getString("text_5");
        text_6 = intent.getExtras().getString("text_6");
        text_7 = intent.getExtras().getString("text_7");
        text_8 = intent.getExtras().getString("text_8");
        text_9 = intent.getExtras().getString("text_9");
        text_10 = intent.getExtras().getString("text_10");
        send_data = "a1=" + text_1 + "&a2=" + text_2 + "&a3=" + text_3 + "&a4=" + text_4 + "&a5=" + text_5 + "&b1=" + text_6 + "&b2=" + text_7 + "&b3=" + text_8 + "&b4=" + text_9 + "&b5=" + text_10 + "&pos=" + text_0;
        //send_data = "a3=7&a5=432&pos=4";

        LVMonitor.mostPick.clear();
        LVMonitor.mostWin.clear();
        LVMonitor.mostLose.clear();
        HttpTask httpTask = new HttpTask();
        httpTask.execute();
        receieve_data = httpTask.data;


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Freq"));
        tabLayout.addTab(tabLayout.newTab().setText("Win"));;
        tabLayout.addTab(tabLayout.newTab().setText("Lose"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {



            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    final class HttpTask extends AsyncTask<Void, Void, Void> {
        String data;
        private HttpURLConnection connection;
        private URL url;

        protected void onPreExecute() {
            try {
                //url = new URL("http://143.248.36.230?"+send_data);
                url = new URL("http://52.34.174.33:3000?"+send_data);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        protected Void doInBackground(Void... params) {
            URLConnection connection = null;
            try {
                connection = url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                JSONObject json = new JSONObject(builder.toString());
                LVMonitor.t.clear();
                LVMonitor.mostPick.clear();
                LVMonitor.mostWin.clear();
                LVMonitor.mostLose.clear();
                for(int i = 0; i < 10; i++){
                    JSONObject dm = json.getJSONObject("dm" + i);

                    if(dm != null)
                        LVMonitor.mostPick.add(new Champion(
                                dm.getString("name"),
                                dm.getDouble("rate"),
                                dm.getInt("count")));
                    JSONObject dw = json.getJSONObject("dw" + i);
                    if(dw != null)
                        LVMonitor.mostWin.add(new Champion(
                                dw.getString("name"),
                                dw.getDouble("rate"),
                                dw.getInt("count")));
                    JSONObject dl = json.getJSONObject("dl" + i);
                    if(dl != null)
                        LVMonitor.mostLose.add(new Champion(
                                dl.getString("name"),
                                dl.getDouble("rate"),
                                dl.getInt("count")));
                }

                receieve_data = json.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            if(Frag_1.adapter1 != null)
                Frag_1.adapter1.notifyDataSetChanged();
            if(Frag_2.adapter2 != null)
                Frag_2.adapter2.notifyDataSetChanged();
            if(Frag_3.adapter3 != null)
                Frag_3.adapter3.notifyDataSetChanged();

            super.onPostExecute(result);

        }
    }
}
