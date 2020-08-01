package com.jdots.ignou;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import java.io.IOException;
import java.io.InputStream;

public class DocviewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjusttheme();
        setContentView(R.layout.activity_docview);

        AdView adView;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        LinearLayout adContainer =  findViewById(R.id.banner_container_doc);
        if( !(prefs.getBoolean("NOADS", false))) {
            adView = new AdView(this, getString(R.string.fan_banner_id), AdSize.BANNER_HEIGHT_50);
            adContainer.setVisibility(View.VISIBLE);
            adContainer.addView(adView);
            adView.loadAd();
        }else
        {
            adContainer.setVisibility(View.GONE);
        }



        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle extras=intent.getExtras();
        String text1=null,text2=null,text3=null;

        if(extras != null){
            text1 = extras.getString(MaterialActivity.TOKEN1);
            text2 = extras.getString(MaterialActivity.TOKEN2);
            text3 = extras.getString(MaterialActivity.TOKEN3);

        }

        TextView textView1 = findViewById(R.id.TXV1);
        textView1.setText(text1);

        TextView textView2 = findViewById(R.id.TXV2);
        textView2.setText(text2);

        final TextView textView3 = findViewById(R.id.TXV3);
        textView3.setText(text3);

        ImageView zoomplus=(ImageView) findViewById(R.id.imageViewZP);
        ImageView zoomminus=(ImageView) findViewById(R.id.imageViewZM);
        ImageView pagenext=(ImageView) findViewById(R.id.imageViewPP);
        ImageView pageprev=(ImageView) findViewById(R.id.imageViewPM);

        final ScrollView Doc=(ScrollView) findViewById(R.id.ScrollViewDoc);


        switch (text3)
        {
            case ("Java language"):
                setDocContent("java","Java Language");
                break;
            case ("C++ language"):
                setDocContent("c++","C++ language");
                break;
            case ("C language"):
                setDocContent("c","C Language");
                break;
            case ("English grammar"):
                setDocContent("english","English grammar");
                break;
            case ("Business organization"):
                setDocContent("eco01","Business organization");
                break;
            case ("Assembly programming and microprocessor"):
                setDocContent("assemblyprogramming","Assembly programming and microprocessor");
                break;
            case ("Data communications and networks"):
                setDocContent("datacommunication","Data communications and networks");
                break;
            case ("Data structures"):
                setDocContent("datastructure","Data structures");
                break;
            case ("Database management system"):
                setDocContent("dbms","Database management system");
                break;
            case ("Internet technology"):
                setDocContent("it","Internet technology");
                break;
            case ("Operating system"):
                setDocContent("os","Operating system");
                break;
            case ("Relational database management system"):
                setDocContent("rdbms","Relational database management system");
                break;
            case ("Software engineering"):
                setDocContent("softengg","Software engineering");
                break;
            case ("Software engineering 2"):
                setDocContent("softenggmca","Software engineering 2");
                break;

        }

        zoomplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ButtonTone();

                //Toast.makeText(getApplicationContext(),"+",Toast.LENGTH_SHORT).show();

                textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX,textView3.getTextSize()+1);
            }
        });
        zoomminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ButtonTone();

             //   Toast.makeText(getApplicationContext(),"-",Toast.LENGTH_SHORT).show();

                textView3.setTextSize(TypedValue.COMPLEX_UNIT_PX,textView3.getTextSize()-1);
            }
        });
        pagenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ButtonTone();

                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();

                Doc.scrollBy(0,-3000);
            }
        });
        pageprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ButtonTone();

               // Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();

                Doc.scrollBy(0,3000);
            }
        });
}
    protected void onDestroy() {



        super.onDestroy();
    }


    public void setDocContent(String file,String title)
    {

        TextView textView1 = findViewById(R.id.TXV1);
        TextView textView2 = findViewById(R.id.TXV2);
        TextView textView3 = findViewById(R.id.TXV3);

        String text = "";
        try {
            InputStream inputStream = getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView3.setText(text);
        textView2.setText(title);
        textView1.setText("Notes");

    }



    public void adjusttheme()
    {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme=prefs.getString("list_preference_theme","1");
        switch(theme)
        {
            case ("Pink-Blue") :
                setTheme(R.style.AppTheme1);
                break;
            case ("Red-Blue") :
                setTheme(R.style.AppTheme2);
                break;
            case ("Blue-Green") :
                setTheme(R.style.AppTheme3);
                break;
            case ("Green-Red") :
                setTheme(R.style.AppTheme4);
                break;
            default:  setTheme(R.style.AppTheme1);

        }
    }


    public void ButtonTone() {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(50);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if(pref.getBoolean("switch_sounds",true))
        {
            mp.start();
        }
    }
    public int getUseCount(Boolean increment) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(increment)
            prefs.edit().putInt("use_count", prefs.getInt("use_count", 0)+1).apply();

        return (prefs.getInt("use_count", 0));
    }

    }

