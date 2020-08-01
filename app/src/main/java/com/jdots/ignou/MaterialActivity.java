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


public class MaterialActivity extends AppCompatActivity {
    public static final String TOKEN1 = "com.jdots.TOKEN1";
    public static final String TOKEN2 = "com.jdots.TOKEN2";
    public static final String TOKEN3 = "com.jdots.TOKEN3";




    /* Called when the user taps the button */

    public void BClick11(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B11);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.FEG_02_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.FEG_02_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca); intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick12(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B12 = (Button) findViewById(R.id.B12);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.ECO_01_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.ECO_01_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca); intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick13(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B13);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_011_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca); intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick14(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B14);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_012_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_012_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca); intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick15(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B15);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_013_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_013_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void BClick21(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B21);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.ECO_02_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.ECO_02_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick22(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B22);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_011_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_011_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void BClick23(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B23);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_012_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_012_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick24(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B24);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_015_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_015_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick25(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B25);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_013_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_013_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick26(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B26);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_021_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_021_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void BClick27(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B27);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_022_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_022_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick31(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B31);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_021_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_021_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick32(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B32);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_023_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_023_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick33(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B33);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_014_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_014_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick34(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B34);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_031_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_031_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick35(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B35);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_032_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_032_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick36(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B36);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_033_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_033_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick37(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B37);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_034_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_034_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick41(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B41);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_040_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_040_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick42(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B42);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_024_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_024_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick43(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B43);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_041_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_041_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick44(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B44);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_042_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_042_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick45(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B45);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_016_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_016_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick46(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B46);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_043_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_043_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick47(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B47);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_044_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_044_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick48(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B48);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_045_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_045_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick51(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B51);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_051_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_051_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick52(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B52);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_052_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_052_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick53(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B53);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_053_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_053_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick54(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B54);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_054_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_054_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick55(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B55);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_055_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_055_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick56(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B56);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_056_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_056_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void BClick57(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B57);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_057_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_057_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick58(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B58);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_058_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_058_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick61(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B61);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCS_062_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCS_062_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_bca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void BClick62(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B62);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_022_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_022_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers"))
        {
            txt3 = getString(R.string.course_bca);
            intent = new Intent(this,  QnActivity.class);
        }
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick63(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B63);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSL_063_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSL_063_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers"))
        {
            txt3 = getString(R.string.course_bca);
            intent = new Intent(this,  QnActivity.class);
        }
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void BClick64(View view) {
        ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.B64);
        Spinner spin1= (Spinner) findViewById(R.id.spin1);
        String txt1 = spin1.getSelectedItem().toString();
        String txt2 = getString(R.string.BCSP_064_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.BCSP_064_syllabus);}
        if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        if(txt1.equals("Question Papers"))
        {
            txt3 = getString(R.string.course_bca);
            intent = new Intent(this,  QnActivity.class);
        }
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjusttheme();
        setContentView(R.layout.activity_material);
/* FAN
        AdView adView;
        adView = new AdView(this, "480154182722596_480166769388004", AdSize.BANNER_HEIGHT_90);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container_bca);adContainer.addView(adView);
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
}