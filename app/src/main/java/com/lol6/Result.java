package com.lol6;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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


    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d("Test", "oncreate");
        textview = (TextView) findViewById(R.id.testbox);



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

        HttpTask httpTask = new HttpTask();
        httpTask.execute();
        receieve_data = httpTask.data;
        Toast.makeText(getApplicationContext(), receieve_data, Toast.LENGTH_LONG).show();

        /*
        try {
            receieve_data = doGetRequest("http://143.248.36.230?"+send_data);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        Log.d("FUCK", receieve_data);
        Toast.makeText(getApplicationContext(), receieve_data, Toast.LENGTH_LONG).show();

        */
        //tv.setText(receieve_data);





        //      NetworkTask net = new NetworkTask();
    //    net.execute("http://143.248.36.230/?" + send_data);

        //Toast.makeText(Result.this, recieve_data, Toast.LENGTH_LONG).show();



        // Toast.makeText(Result.this, recieve_data, Toast.LENGTH_SHORT).show();


       /* Toast.makeText(Result.this, text_0, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_1, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_2, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_3, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_4, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_5, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_6, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_7, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_8, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_9, Toast.LENGTH_SHORT).show();
        Toast.makeText(Result.this, text_10, Toast.LENGTH_SHORT).show();    */



        //String wow = "" + text_0 + text_1 + text_2 + text_3 + text_4 + text_5 + text_6 + text_7 + text_8 + text_9 + text_10;





        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Most freq"));
        tabLayout.addTab(tabLayout.newTab().setText("Most win"));
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
                url = new URL("http://143.248.36.230?"+send_data);
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

                receieve_data = json.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            textview.setText(receieve_data);
            super.onPostExecute(result);
        }
    }
}
