package com.jdots.ignou;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class BAMaterialActivity extends AppCompatActivity {

    public static final String TOKEN1 = "com.jdots.TOKEN1";
    public static final String TOKEN2 = "com.jdots.TOKEN2";
    public static final String TOKEN3 = "com.jdots.TOKEN3";


    /* Called when the user taps the button */

    public void BAClick11(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA11);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.FEG_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FEG_01_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BAClick12(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B12 = (Button) findViewById(R.id.BA12);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.FST_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FST_01_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BAClick13(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B13 = (Button) findViewById(R.id.BA13);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 =getString(R.string.BHDF_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BHDF_01_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BAClick14(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA14);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.FHS_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FHS_01_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BAClick15(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA15);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.FEG_02_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FEG_02_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    public void BAClick16(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA15);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 =getString(R.string.FML_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FML_01_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BAClick21(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA21);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.BEGE_101_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BEGE_101_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BAClick22(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA22);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 =getString(R.string.EEG_02_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_02_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void BAClick23(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA23);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 =getString(R.string.EEG_03_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_03_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BAClick24(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA24);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 =getString(R.string.EEG_04_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_04_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BAClick25(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA25);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.EEG_05_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_05_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    public void BAClick26(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA25);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.EEG_06_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_06_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void BAClick31(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA31);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.EEG_07_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_07_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BAClick32(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA32);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.EEG_08_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.EEG_08_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BAClick33(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA33);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.AFW_E_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.AFW_E_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BAClick34(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA34);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.AWR_E_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.AWR_E_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BAClick35(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.BA35);
        Spinner spin3= (Spinner) findViewById(R.id.spin3);
        String txt1 = spin3.getSelectedItem().toString();
        String txt2 = getString(R.string.AWR_H_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.AWR_H_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_ba);
            intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjusttheme();
        setContentView(R.layout.activity_material_ba);
/* FAN
        AdView adView;
        adView = new AdView(this, "480154182722596_480166769388004", AdSize.BANNER_HEIGHT_90);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container_ba);adContainer.addView(adView);
        adView.loadAd();
*/



    }
    public int getUseCount(Boolean increment) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(increment)
            prefs.edit().putInt("use_count", prefs.getInt("use_count", 0)+1).apply();

        return (prefs.getInt("use_count", 0));
    }
    protected void onDestroy() {



        super.onDestroy();
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
}