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

public class MCAMaterialActivity extends AppCompatActivity {

    public static final String TOKEN1 = "com.jdots.TOKEN1";
    public static final String TOKEN2 = "com.jdots.TOKEN2";
    public static final String TOKEN3 = "com.jdots.TOKEN3";



    /* Called when the user taps the button */

    public void MClick11(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M11);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_011_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_011_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick12(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B12 = (Button) findViewById(R.id.M12);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_012_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_012_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick13(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M13);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_013_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_013_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick14(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M14);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_014_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_014_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick15(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M15);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_015_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_015_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick16(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M16);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_016_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_016_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick17(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M17);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_017_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_017_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick21(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M21);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_021_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_021_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick22(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M22);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_022_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_022_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }
    /* Called when the user taps the button */

    public void MClick23(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M23);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_023_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_023_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick24(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M24);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_024_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_024_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick25(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M25);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_025_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_025_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick31(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M31);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_031_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_031_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick32(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M32);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_032_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_032_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick33(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M33);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_033_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_033_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick34(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M34);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_034_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_034_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick35(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M35);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_035_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_035_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick36(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M36);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_036_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_036_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick41(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M41);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_041_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_041_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick42(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M42);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_042_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_042_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick43(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M43);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_043_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_043_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick44(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M44);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_044_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_044_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick45(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M45);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_045_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_045_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick51(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M51);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_051_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_051_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick52(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M52);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_052_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_052_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick53(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M53);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCS_053_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCS_053_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick54(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M54);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSL_054_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSL_054_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    /* Called when the user taps the button */

    public void MClick55(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M55);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSE_003_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSE_003_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick56(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M56);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSE_004_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSE_004_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }



    /* Called when the user taps the button */

    public void MClick57(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M57);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSE_011_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSE_011_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }

    /* Called when the user taps the button */

    public void MClick61(View view) {  ButtonTone();
        Intent intent = new Intent(this,  DocviewActivity.class);
        Button B11 = (Button) findViewById(R.id.M61);
        Spinner spin2= (Spinner) findViewById(R.id.spin2);
        String txt1 = spin2.getSelectedItem().toString();
        String txt2 = getString(R.string.MCSSP_060_title);
        String txt3=null;
        if(txt1.equals("Syllabus")){ txt3 = getString(R.string.MCSSP_060_syllabus);}
        else if(txt1.equals("Summary")){ txt3 = getString(R.string.BCS_011_syllabus);}
        else if(txt1.equals("Question Papers")){ txt3 = getString(R.string.course_mca);intent = new Intent(this,  QnActivity.class);}
        intent.putExtra(TOKEN1,txt1);
        intent.putExtra(TOKEN2,txt2);
        intent.putExtra(TOKEN3,txt3);

        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjusttheme();
        setContentView(R.layout.activity_material_mca);
/* FAN
        AdView adView;
        adView = new AdView(this, "480154182722596_480166769388004", AdSize.BANNER_HEIGHT_90);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container_mca);adContainer.addView(adView);
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