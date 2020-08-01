package com.jdots.ignou;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import java.util.Random;

import es.dmoral.toasty.Toasty;


public class PuzzleActivity extends AppCompatActivity {

    public int score=0;
    public int i=0;




    String chooseoperator()
    {
        Random R=new Random();
        int val=R.nextInt(4);
        switch(val)
        {
            case(0):return "+";
            case(1):return "-";
            case(2):return "\u00D7";
            case(3):return "\u00F7";
            default:return "+";
        }
    }
    double calculate(String op,double o1,double o2)
    {
        switch(op)
        {
            case("+"):return o1+o2;
            case("-"):return o1-o2;
            case("\u00D7"):return o1*o2;
            case("\u00F7"): if(o2!=0){return o1/o2;}
            default:return 0;
        }
    }
    void newpuzzle()
    {
        final  ProgressBar mProgress=(ProgressBar) findViewById(R.id.progressBartime);
        final SeekBar S=(SeekBar) findViewById(R.id.seekBarHard);
        final Button Ba = (Button) findViewById(R.id.buttona);
        final Button Bb = (Button) findViewById(R.id.buttonb);
        final TextView Ta = (TextView) findViewById(R.id.textViewa);
        final TextView Tb = (TextView) findViewById(R.id.textViewb);
        final TextView Tc = (TextView) findViewById(R.id.textViewc);
        final RadioButton r1=(RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2=(RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3=(RadioButton) findViewById(R.id.radioButton3);
        final RadioButton r4=(RadioButton) findViewById(R.id.radioButton4);
        final RadioButton r5=(RadioButton) findViewById(R.id.radioButton5);
        final TextView scr=(TextView) findViewById(R.id.scorecard);
        final  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        CountDownTimer Counter;

        scr.setText("0");

        final Random r = new Random();

        int data1 = r.nextInt(S.getProgress() + 1);
        int data2 = r.nextInt(S.getProgress() + 1);

        if (data1 < data2) {
            int temp = data1;
            data1 = data2;
            data2 = temp;
        }
        Tb.setText(chooseoperator());

        if (Tb.getText().toString().equals("\u00F7")) {
            int temp = data1;
            data1 = data1 * r.nextInt(S.getProgress() + 1);
            data2 = temp;
            if (data2 == 0) {
                data2 = 1;
            }
        }

        Ta.setText(String.valueOf(data1));
        Tc.setText(String.valueOf(data2));

        scr.setText(String.valueOf(score * (S.getProgress() + 1)));

        double oper1 = Double.parseDouble(Ta.getText().toString());
        double oper2 = Double.parseDouble(Tc.getText().toString());
        double result = calculate(Tb.getText().toString(), oper1, oper2);

        do {

            int val = (r.nextInt(5));

            switch (val) {
                case 0:
                    r1.setText(Double.toString(result));
                    r2.setText(Double.toString(result + r.nextInt(100)));
                    r3.setText(Double.toString(result + r.nextInt(10) * 2));
                    r4.setText(Double.toString(result + r.nextInt(200)));
                    r5.setText(Double.toString(result - r.nextInt(2) + 1));
                    break;
                case 1:
                    r2.setText(Double.toString(result));
                    r1.setText(Double.toString(result + r.nextInt(100)));
                    r3.setText(Double.toString(result + r.nextInt(10) * 2));
                    r4.setText(Double.toString(result + r.nextInt(200)));
                    r5.setText(Double.toString(result - r.nextInt(2) + 1));
                    break;
                case 2:
                    r3.setText(Double.toString(result));
                    r2.setText(Double.toString(result + r.nextInt(100)));
                    r1.setText(Double.toString(result + r.nextInt(10) * 2));
                    r4.setText(Double.toString(result + r.nextInt(200)));
                    r5.setText(Double.toString(result - r.nextInt(2) + 1));
                    break;
                case 3:
                    r4.setText(Double.toString(result));
                    r2.setText(Double.toString(result + r.nextInt(100)));
                    r3.setText(Double.toString(result + r.nextInt(10) * 2));
                    r1.setText(Double.toString(result + r.nextInt(200)));
                    r5.setText(Double.toString(result - r.nextInt(2) + 1));
                    break;
                case 4:
                    r5.setText(Double.toString(result));
                    r2.setText(Double.toString(result + r.nextInt(100)));
                    r3.setText(Double.toString(result + r.nextInt(10) * 2));
                    r4.setText(Double.toString(result + r.nextInt(200)));
                    r1.setText(Double.toString(result - r.nextInt(2) + 1));
                    break;
            }
        } while ((r1.getText().toString().equals(r2.getText().toString()))||
                (r1.getText().toString().equals(r3.getText().toString()))||
                (r1.getText().toString().equals(r4.getText().toString()))||
                (r1.getText().toString().equals(r5.getText().toString()))||
                (r2.getText().toString().equals(r3.getText().toString()))||
                (r2.getText().toString().equals(r4.getText().toString()))||
                (r2.getText().toString().equals(r5.getText().toString()))||
                (r3.getText().toString().equals(r4.getText().toString()))||
                (r3.getText().toString().equals(r5.getText().toString()))||
                (r4.getText().toString().equals(r5.getText().toString())));

    }
    void checkfalse()
    {
        RadioButton r1=(RadioButton) findViewById(R.id.radioButton1);
        RadioButton r2=(RadioButton) findViewById(R.id.radioButton2);
        RadioButton r3=(RadioButton) findViewById(R.id.radioButton3);
        RadioButton r4=(RadioButton) findViewById(R.id.radioButton4);
        RadioButton r5=(RadioButton) findViewById(R.id.radioButton5);
        r1.setChecked(true);
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        r5.setChecked(false);

    }
    void timerinit()
    {
        final  ProgressBar mProgress=(ProgressBar) findViewById(R.id.progressBartime);
        final SeekBar S=(SeekBar) findViewById(R.id.seekBarHard);
        final Button Ba = (Button) findViewById(R.id.buttona);
        final Button Bb = (Button) findViewById(R.id.buttonb);


        i=1;
        score=0;

        mProgress.setVisibility(View.VISIBLE);
        Ba.setEnabled(true);
        Bb.setEnabled(false);

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                i++;
                if (mProgress.getProgress() < mProgress.getMax()){ mProgress.setProgress(i);}
                else {mProgress.setProgress(1);}
            }
            public void onFinish() {
               if (mProgress.getProgress()==mProgress.getMax())
               {

                   mProgress.setVisibility(View.INVISIBLE);
                   Ba.setEnabled(false);
                   Bb.setEnabled(true);

                       Toasty.info(getApplicationContext(), "Time Over\nFinal Score : " + String.valueOf(score*(S.getProgress()+1)),
                        Toast.LENGTH_LONG,true).show();
               }
            }}.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adjusttheme();
        setContentView(R.layout.activity_puzzle);

        AdView adView;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        LinearLayout adContainer =  findViewById(R.id.banner_container_puzzle);
        if( !(prefs.getBoolean("NOADS", false))) {
            adView = new AdView(this, getString(R.string.fan_banner_id), AdSize.BANNER_HEIGHT_50);
            adContainer.setVisibility(View.VISIBLE);
            adContainer.addView(adView);
            adView.loadAd();
        }else
        {
            adContainer.setVisibility(View.GONE);
        }


        final  ProgressBar mProgress=(ProgressBar) findViewById(R.id.progressBartime);
        final SeekBar S=(SeekBar) findViewById(R.id.seekBarHard);
        final Button Ba = (Button) findViewById(R.id.buttona);
        final Button Bb = (Button) findViewById(R.id.buttonb);
        final TextView Ta = (TextView) findViewById(R.id.textViewa);
        final TextView Tb = (TextView) findViewById(R.id.textViewb);
        final TextView Tc = (TextView) findViewById(R.id.textViewc);
        final RadioButton r1=(RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2=(RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3=(RadioButton) findViewById(R.id.radioButton3);
        final RadioButton r4=(RadioButton) findViewById(R.id.radioButton4);
        final RadioButton r5=(RadioButton) findViewById(R.id.radioButton5);
        final TextView scr=(TextView) findViewById(R.id.scorecard);
/*
        final  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            alertDialogBuilder.setMessage("Start new puzzle ? ");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    timerinit();
                                    newpuzzle();
                                    checkfalse();
                                }
                            });

            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
               @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
*/
        final NiftyDialogBuilder dialogBuilder= NiftyDialogBuilder.getInstance(this);

        dialogBuilder
                .withTitle("MATHS PUZZLE")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("Start new puzzle ? ")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
                .withIcon(getResources().getDrawable(R.drawable.jdots))
                .withDuration(700)                                          //def
                .withEffect(Effectstype.Flipv)                                         //def Effectstype.Slidetop
                .withButton1Text("Yes")                                      //def gone
                .withButton2Text("No")                                  //def gone
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                // .setCustomView(View or ResId,context)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timerinit();
                        newpuzzle();
                        checkfalse();
                        dialogBuilder.dismiss();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        dialogBuilder.dismiss();
                    }
                })
                .show();


            //
        mProgress.setVisibility(View.INVISIBLE);

        S.setProgress(50);
        newpuzzle();
        checkfalse();

        Ba.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ButtonTone();
                String txt="";

                boolean checked=r1.isChecked();
                if (checked==true)  {txt= r1.getText().toString();}
                checked=r2.isChecked();
                if (checked==true)  {txt= r2.getText().toString();}
                checked=r3.isChecked();
                if (checked==true)  {txt= r3.getText().toString();}
                checked=r4.isChecked();
                if (checked==true)  {txt= r4.getText().toString();}
                checked=r5.isChecked();
                if (checked==true)  {txt= r5.getText().toString();}

                if((Ta.getText().length()>0) && (Tc.getText().length()>0))
                {
                    double oper1 = Double.parseDouble(Ta.getText().toString());
                    double oper2 = Double.parseDouble(Tc.getText().toString());
                    double result = calculate(Tb.getText().toString(),oper1,oper2);

                    if(Double.toString(result).equals(txt))
                    {
                        Toasty.success(getApplicationContext(), "Correct", Toast.LENGTH_SHORT, true).show();

                       // Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        score++;
                    }
                    else
                    {
                        Toasty.error(getApplicationContext(), "Wrong Option \nAnswer : " + Double.toString(result) , Toast.LENGTH_SHORT, true).show();

                       // Toast.makeText(getApplicationContext(), "Wrong Option \nAnswer : " + Double.toString(result) , Toast.LENGTH_SHORT).show();
                        if(score>0){score--;}
                    }
                }

                newpuzzle();
                checkfalse();

            }
        });
        Bb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timerinit();
                newpuzzle();
                checkfalse();

              ButtonTone();

            }
        });
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

    public void adjusttheme() {

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