package com.lol6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arraylist;
    ArrayList<String> champion;
    ArrayList<String> champion_number;
    Spinner sp;
    Spinner sp_1;
    Spinner sp_2;
    Spinner sp_3;
    Spinner sp_4;
    Spinner sp_5;
    Spinner sp_6;
    Spinner sp_7;
    Spinner sp_8;
    Spinner sp_9;
    Spinner sp_10;
    String text_0;
    String text_1 = "SELECT";
    String text_2 = "SELECT";
    String text_3 = "SELECT";
    String text_4 = "SELECT";
    String text_5 = "SELECT";
    String text_6 = "SELECT";
    String text_7 = "SELECT";
    String text_8 = "SELECT";
    String text_9 = "SELECT";
    String text_10 = "SELECT";

     Integer images[] = {R.drawable.oh,R.drawable.aatrox,
    R.drawable.ahri,R.drawable.akali,R.drawable.alistar,
    R.drawable.amumu,R.drawable.anivia,R.drawable.annie,
    R.drawable.ashe,R.drawable.azir,R.drawable.bard,
            R.drawable.blitzcrank,R.drawable.brand,R.drawable.braum
            ,R.drawable.caitlyn,R.drawable.cassiopeia,R.drawable.chogath
             ,R.drawable.corki,R.drawable.darius,R.drawable.diana
             ,R.drawable.drmundo,R.drawable.draven,R.drawable.ekko
             ,R.drawable.elise,R.drawable.evelynn,R.drawable.ezreal
             ,R.drawable.fiddlesticks,R.drawable.fiora,R.drawable.fizz
             ,R.drawable.galio,R.drawable.gangplank,R.drawable.garen
             ,R.drawable.gnar,R.drawable.gragas,R.drawable.graves
             ,R.drawable.hecarim,R.drawable.heimerdinger,R.drawable.illaoi
            ,R.drawable.irelia,R.drawable.janna,R.drawable.jarvaniv
            ,R.drawable.jax,R.drawable.jayce,R.drawable.jinx,R.drawable.kalista
            ,R.drawable.karma,R.drawable.karthus,R.drawable.kassadin
            ,R.drawable.katarina,R.drawable.kayle,R.drawable.kennen
            ,R.drawable.khazix,R.drawable.kindred,R.drawable.kogmaw
            ,R.drawable.leblanc,R.drawable.leesin,R.drawable.leona
            ,R.drawable.lissandra,R.drawable.lucian,R.drawable.lulu
            ,R.drawable.lux,R.drawable.malphite,R.drawable.malzahar
            ,R.drawable.maokai,R.drawable.masteryi,R.drawable.missfortune
            ,R.drawable.monkeyking,R.drawable.mordekaiser,R.drawable.morgana
            ,R.drawable.nami,R.drawable.nasus,R.drawable.nautilus
            ,R.drawable.nidalee,R.drawable.nocturne,R.drawable.nunu
            ,R.drawable.olaf,R.drawable.orianna,R.drawable.pantheon
            ,R.drawable.poppy,R.drawable.quinn,R.drawable.rammus,R.drawable.reksai
            ,R.drawable.renekton,R.drawable.rengar,R.drawable.riven
            ,R.drawable.rumble,R.drawable.ryze,R.drawable.sejuani
            ,R.drawable.shaco,R.drawable.shen,R.drawable.shyvana,R.drawable.singed
            ,R.drawable.sion,R.drawable.sivir,R.drawable.skarner,R.drawable.sona
            ,R.drawable.soraka,R.drawable.swain,R.drawable.syndra
            ,R.drawable.tahmkench,R.drawable.talon,R.drawable.taric
            ,R.drawable.teemo,R.drawable.thresh,R.drawable.tristana
            ,R.drawable.trundle,R.drawable.tryndamere,R.drawable.twistedfate
            ,R.drawable.twitch,R.drawable.udyr,R.drawable.urgot,R.drawable.varus
            ,R.drawable.vayne,R.drawable.veigar,R.drawable.velkoz,R.drawable.vi
            ,R.drawable.viktor,R.drawable.vladimir,R.drawable.volibear
            ,R.drawable.warwick,R.drawable.xerath,R.drawable.xinzhao
            ,R.drawable.yasuo,R.drawable.yorick,R.drawable.zac,R.drawable.zed
            ,R.drawable.ziggs,R.drawable.zilean,R.drawable.zyra};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                text_0 = sp.getSelectedItem().toString();
                text_1 = sp_1.getSelectedItem().toString();
                //Toast.makeText(MainActivity.this, text_0, Toast.LENGTH_SHORT).show();
                text_2 = sp_2.getSelectedItem().toString();
                text_3 = sp_3.getSelectedItem().toString();
                text_4 = sp_4.getSelectedItem().toString();
                text_5 = sp_5.getSelectedItem().toString();
                text_6 = sp_6.getSelectedItem().toString();
                text_7 = sp_7.getSelectedItem().toString();
                text_8 = sp_8.getSelectedItem().toString();
                text_9 = sp_9.getSelectedItem().toString();
                text_10 = sp_10.getSelectedItem().toString();
                //go to next activity with data
                Intent intent = new Intent(MainActivity.this, Result.class);
                if(text_0.equals("Top")){
                    intent.putExtra("text_0", "1");
                }
                else if(text_0.equals("Jungle")){
                    intent.putExtra("text_0", "2");
                }
                else if(text_0.equals("Mid")){
                    intent.putExtra("text_0", "3");
                }
                else if(text_0.equals("AD")){
                    intent.putExtra("text_0", "4");
                }
                else if(text_0.equals("Support")){
                    intent.putExtra("text_0", "5");
                }

                intent.putExtra("text_1", champion_number.get(champion.indexOf(text_1)));
                intent.putExtra("text_2", champion_number.get(champion.indexOf(text_2)));
                intent.putExtra("text_3", champion_number.get(champion.indexOf(text_3)));
                intent.putExtra("text_4", champion_number.get(champion.indexOf(text_4)));
                intent.putExtra("text_5", champion_number.get(champion.indexOf(text_5)));
                intent.putExtra("text_6", champion_number.get(champion.indexOf(text_6)));
                intent.putExtra("text_7", champion_number.get(champion.indexOf(text_7)));
                intent.putExtra("text_8", champion_number.get(champion.indexOf(text_8)));
                intent.putExtra("text_9", champion_number.get(champion.indexOf(text_9)));
                intent.putExtra("text_10", champion_number.get(champion.indexOf(text_10)));
                startActivity(intent);
            }

        });

        arraylist = new ArrayList<String>();
        arraylist.add("Top");
        arraylist.add("Mid");
        arraylist.add("Jungle");
        arraylist.add("AD");
        arraylist.add("Support");


        String champ_id = "0: SELECT,1:Annie,2:Olaf,3:Galio,4:TwistedFate,5:XinZhao,6:Urgot,7:Leblanc,8:Vladimir,9:FiddleSticks,10:Kayle,11:MasterYi,12:Alistar,13:Ryze,14:Sion,15:Sivir,16:Soraka,17:Teemo,18:Tristana,19:Warwick,20:Nunu,21:MissFortune,22:Ashe,23:Tryndamere,24:Jax,25:Morgana,26:Zilean,27:Singed,28:Evelynn,29:Twitch,30:Karthus,31:Chogath,32:Amumu,33:Rammus,34:Anivia,35:Shaco,36:DrMundo,37:Sona,38:Kassadin,39:Irelia,40:Janna,41:Gangplank,42:Corki,43:Karma,44:Taric,45:Veigar,48:Trundle,50:Swain,51:Caitlyn,53:Blitzcrank,54:Malphite,55:Katarina,56:Nocturne,57:Maokai,58:Renekton,59:JarvanIV,60:Elise,61:Orianna,62:MonkeyKing,63:Brand,64:LeeSin,67:Vayne,68:Rumble,69:Cassiopeia,72:Skarner,74:Heimerdinger,75:Nasus,76:Nidalee,77:Udyr,78:Poppy,79:Gragas,80:Pantheon,81:Ezreal,82:Mordekaiser,83:Yorick,84:Akali,85:Kennen,86:Garen,89:Leona,90:Malzahar,91:Talon,92:Riven,96:KogMaw,98:Shen,99:Lux,101:Xerath,102:Shyvana,103:Ahri,104:Graves,105:Fizz,106:Volibear,107:Rengar,110:Varus,111:Nautilus,112:Viktor,113:Sejuani,114:Fiora,115:Ziggs,117:Lulu,119:Draven,120:Hecarim,121:Khazix,122:Darius,126:Jayce,127:Lissandra,131:Diana,133:Quinn,134:Syndra,143:Zyra,150:Gnar,154:Zac,157:Yasuo,161:Velkoz,201:Braum,203:Kindred,222:Jinx,223:TahmKench,236:Lucian,238:Zed,245:Ekko,254:Vi,266:Aatrox,267:Nami,268:Azir,412:Thresh,420:Illaoi,421:RekSai,429:Kalista,432:Bard";
        String champ[] = champ_id.split(",");
        for(int i=0;i<champ.length;i++){
            champ[i] = champ[i].split(":")[1] + ":" + champ[i].split(":")[0]; // "SELECT:0,Annie:1,Olaf:2, .... "
        }
        Arrays.sort(champ);


        champion = new ArrayList<String>();
        champion_number = new ArrayList<String>();
        for(int i=0;i<champ.length;i++){
            champion.add(champ[i].split(":")[0]);
            champion_number.add(champ[i].split(":")[1]);
        }
        /*CustomAdapter adapter_1 = new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion, images);*/
        //스피너 속성
        sp_1 = (Spinner) this.findViewById(R.id.spinner_1);
        sp_2 = (Spinner) this.findViewById(R.id.spinner_2);
        sp_3 = (Spinner) this.findViewById(R.id.spinner_3);
        sp_4 = (Spinner) this.findViewById(R.id.spinner_4);
        sp_5 = (Spinner) this.findViewById(R.id.spinner_5);
        sp_6 = (Spinner) this.findViewById(R.id.spinner_6);
        sp_7 = (Spinner) this.findViewById(R.id.spinner_7);
        sp_8 = (Spinner) this.findViewById(R.id.spinner_8);
        sp_9 = (Spinner) this.findViewById(R.id.spinner_9);
        sp_10 = (Spinner) this.findViewById(R.id.spinner_10);
        sp_1.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_2.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_3.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_4.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_5.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_6.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_7.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_8.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_9.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));
        sp_10.setAdapter(new CustomAdapter(MainActivity.this,
                R.layout.spinner_item, champion));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, arraylist);
        //스피너 속성
        sp = (Spinner) this.findViewById(R.id.spinner);
        sp.setAdapter(adapter);
    }
    public class CustomAdapter extends ArrayAdapter {

        public CustomAdapter(Context context, int textViewResourceId,
                         ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

// Inflating the layout for the custom Spinner
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.spinner_item, parent, false);

// Declaring and Typecasting the textview in the inflated layout
            TextView tvLanguage = (TextView) layout
                    .findViewById(R.id.spin_text);

// Setting the text using the array
            tvLanguage.setText(champion.get(position));


// Declaring and Typecasting the imageView in the inflated layout
            ImageView img = (ImageView)layout.findViewById(R.id.image);

// Setting an image using the id's in the array
            img.setImageResource(images[position]);

// Setting Special atrributes for 1st element
            if (position == 0) {
// Removing the image view
                img.setVisibility(View.GONE);
// Setting the size of the text
                tvLanguage.setTextSize(20f);
// Setting the text Color
                tvLanguage.setTextColor(Color.BLACK);

            }

            return layout;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

