package com.jdots.ignou;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import es.dmoral.toasty.Toasty;


public class QnActivity extends AppCompatActivity {


    private   ImageView b1,b2;
    private SubsamplingScaleImageView sw;
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjusttheme();
        setContentView(R.layout.activity_qn);

        AdView adView;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        LinearLayout adContainer =  findViewById(R.id.banner_container_qn);
        if( !(prefs.getBoolean("NOADS", false))) {
            adView = new AdView(this, getString(R.string.fan_banner_id), AdSize.BANNER_HEIGHT_50);
            adContainer.setVisibility(View.VISIBLE);
            adContainer.addView(adView);
            adView.loadAd();
        }else
        {
            adContainer.setVisibility(View.GONE);
        }


        b1 = (ImageView) findViewById(R.id.imv1);
        b2 = (ImageView) findViewById(R.id.imv2);

        sw = (SubsamplingScaleImageView) findViewById(R.id.imageViewZ) ;


        Intent intent = getIntent();
        Bundle extras=intent.getExtras();
        String text1=null;
        String text2=null;
        if(extras != null)
        {
            text1 = extras.getString(MaterialActivity.TOKEN2);
            text2= extras.getString(MaterialActivity.TOKEN3);
        }

        final int Q1;
        final int Q2;


        if (text2.equals(getString(R.string.course_bca))) {

            b2.setVisibility(View.VISIBLE);
            if (text1.equals(getString(R.string.FEG_02_title))) {
                Q1 = R.drawable.feg02_1;
                Q2 = R.drawable.feg02_2;
            } else if (text1.equals(getString(R.string.ECO_01_title))) {
                Q1 = R.drawable.eco01_1;
                Q2 = R.drawable.eco01_2;
            } else if (text1.equals(getString(R.string.BCS_011_title))) {
                Q1 = R.drawable.bcs11_1;
                Q2 = R.drawable.bcs11_2;
            } else if (text1.equals(getString(R.string.BCS_012_title))) {
                Q1 = R.drawable.bcs12_1;
                Q2 = R.drawable.bcs12_2;
            } else if (text1.equals(getString(R.string.BCSL_013_title))) {
                Q1 = R.drawable.bcsl13_1;
                Q2 = R.drawable.bcsl13_2;
            } else if (text1.equals(getString(R.string.ECO_02_title))) {
                Q1 = R.drawable.eco02_1;
                Q2 = R.drawable.eco02_2;
            } else if (text1.equals(getString(R.string.MCS_011_title))) {
                Q1 = R.drawable.mcs11_1;
                Q2 = R.drawable.mcs11_2;
            } else if (text1.equals(getString(R.string.MCS_012_title))) {
                Q1 = R.drawable.mcs12_1;
                Q2 = R.drawable.mcs12_2;
            } else if (text1.equals(getString(R.string.MCS_015_title))) {
                Q1 = R.drawable.mcs15_1;
                Q2 = R.drawable.mcs15_2;
            } else if (text1.equals(getString(R.string.MCS_013_title))) {
                Q1 = R.drawable.mcs12_1;
                Q2 = R.drawable.mcs12_2;
            } else if (text1.equals(getString(R.string.BCSL_021_title))) {
                Q1 = R.drawable.bcsl21_1;
                Q2 = R.drawable.bcsl21_2;
            } else if (text1.equals(getString(R.string.BCSL_022_title))) {
                Q1 = R.drawable.bcsl22_1;
                Q2 = R.drawable.bcsl22_2;
            } else if (text1.equals(getString(R.string.MCS_021_title))) {
                Q1 = R.drawable.mcs21_1;
                Q2 = R.drawable.mcs21_2;
            } else if (text1.equals(getString(R.string.MCS_023_title))) {
                Q1 = R.drawable.mcs23_1;
                Q2 = R.drawable.mcs23_2;
            } else if (text1.equals(getString(R.string.MCS_014_title))) {
                Q1 = R.drawable.mcs14_1;
                Q2 = R.drawable.mcs14_2;
            } else if (text1.equals(getString(R.string.BCS_031_title))) {
                Q1 = R.drawable.bcs31_1;
                Q2 = R.drawable.bcs31_2;
            } else if (text1.equals(getString(R.string.BCSL_032_title))) {
                Q1 = R.drawable.bcsl32_1;
                Q2 = R.drawable.bcsl32_2;
            } else if (text1.equals(getString(R.string.BCSL_033_title))) {
                Q1 = R.drawable.bcsl33_1;
                Q2 = R.drawable.bcsl33_2;
            } else if (text1.equals(getString(R.string.BCSL_034_title))) {
                Q1 = R.drawable.bcsl34_1;
                Q2 = R.drawable.bcsl34_2;
            } else if (text1.equals(getString(R.string.BCS_040_title))) {
                Q1 = R.drawable.bcs40_1;
                Q2 = R.drawable.bcs40_2;
            } else if (text1.equals(getString(R.string.MCS_024_title))) {
                Q1 = R.drawable.mcs24_1;
                Q2 = R.drawable.mcs24_2;
            } else if (text1.equals(getString(R.string.BCS_041_title))) {
                Q1 = R.drawable.bcs41_1;
                Q2 = R.drawable.bcs41_2;
            } else if (text1.equals(getString(R.string.BCS_042_title))) {
                Q1 = R.drawable.bcs42_1;
                Q2 = R.drawable.bcs42_2;
            } else if (text1.equals(getString(R.string.MCSL_016_title))) {
                Q1 = R.drawable.mcsl16_1;
                Q2 = R.drawable.mcsl16_2;
            } else if (text1.equals(getString(R.string.BCSL_043_title))) {
                Q1 = R.drawable.bcsl43_1;
                Q2 = R.drawable.bcsl43_2;
            } else if (text1.equals(getString(R.string.BCSL_044_title))) {
                Q1 = R.drawable.bcsl44_1;
                Q2 = R.drawable.bcsl44_2;
            } else if (text1.equals(getString(R.string.BCSL_045_title))) {
                Q1 = R.drawable.bcsl45_1;
                Q2 = R.drawable.bcsl45_2;
            } else if (text1.equals(getString(R.string.BCS_051_title))) {
                Q1 = R.drawable.bcs51_1;
                Q2 = R.drawable.bcs51_2;
            } else if (text1.equals(getString(R.string.BCS_052_title))) {
                Q1 = R.drawable.bcs52_1;
                Q2 = R.drawable.bcs52_2;
            } else if (text1.equals(getString(R.string.BCS_053_title))) {
                Q1 = R.drawable.bcs53_1;
                Q2 = R.drawable.bcs53_2;
            } else if (text1.equals(getString(R.string.BCS_054_title))) {
                Q1 = R.drawable.bcs54_1;
                Q2 = R.drawable.bcs54_2;
            } else if (text1.equals(getString(R.string.BCS_055_title))) {
                Q1 = R.drawable.bcs55_1;
                Q2 = R.drawable.bcs55_2;
            } else if (text1.equals(getString(R.string.BCSL_056_title))) {
                Q1 = R.drawable.bcsl56_1;
                Q2 = R.drawable.bcsl56_2;
            } else if (text1.equals(getString(R.string.BCSL_057_title))) {
                Q1 = R.drawable.bcsl57_1;
                Q2 = R.drawable.bcsl57_2;
            } else if (text1.equals(getString(R.string.BCS_062_title))) {
                Q1 = R.drawable.bcs62_1;
                Q2 = R.drawable.bcs62_2;
            } else if (text1.equals(getString(R.string.MCS_022_title))) {
                Q1 = R.drawable.mcs22_1;
                Q2 = R.drawable.mcs22_2;
            } else if (text1.equals(getString(R.string.BCSL_063_title))) {
                Q1 = R.drawable.bcsl63_1;
                Q2 = R.drawable.bcsl63_2;
            } else if (text1.equals(getString(R.string.BCS_054_title))) {
                Q1 = R.drawable.bcs54_1;
                Q2 = R.drawable.bcs54_2;
            }  else {
                Q1 = R.drawable.qn_null;
                Q2 = R.drawable.qn_null;
            }
        }else if (text2.equals(getString(R.string.course_mca))) {
            b2.setVisibility(View.VISIBLE);

            if (text1.equals(getString(R.string.MCSL_017_title))) {
                Q1 = R.drawable.mcsl017_mca;
                Q2 = R.drawable.mcsl017_2_mca;
            } else if (text1.equals(getString(R.string.MCSL_025_title))) {
                Q1 = R.drawable.mcsl025_mca;
                Q2 = R.drawable.mcsl025_2_mca;
            } else if (text1.equals(getString(R.string.MCS_031_title))) {
                Q1 = R.drawable.mcs031_mca;
                Q2 = R.drawable.mcs031_2_mca;
            } else if (text1.equals(getString(R.string.MCS_032_title))) {
                Q1 = R.drawable.mcs032_mca;
                Q2 = R.drawable.mcs032_2_mca;
            } else if (text1.equals(getString(R.string.MCS_033_title))) {
                Q1 = R.drawable.mcs033_mca;
                Q2 = R.drawable.mcs033_2_mca;
            } else if (text1.equals(getString(R.string.MCS_034_title))) {
                Q1 = R.drawable.mcs034_mca;
                Q2 = R.drawable.mcs034_2_mca;
            } else if (text1.equals(getString(R.string.MCS_035_title))) {
                Q1 = R.drawable.mcs035_mca;
                Q2 = R.drawable.mcs035_2_mca;
            } else if (text1.equals(getString(R.string.MCSL_036_title))) {
                Q1 = R.drawable.mcsl036_mca;
                Q2 = R.drawable.mcsl036_2_mca;
            } else if (text1.equals(getString(R.string.MCS_041_title))) {
                Q1 = R.drawable.mcs041_mca;
                Q2 = R.drawable.mcs041_2_mca;
            } else if (text1.equals(getString(R.string.MCS_042_title))) {
                Q1 = R.drawable.mcs042_mca;
                Q2 = R.drawable.mcs042_2_mca;
            } else if (text1.equals(getString(R.string.MCS_043_title))) {
                Q1 = R.drawable.mcs043_mca;
                Q2 = R.drawable.mcs043_2_mca;
            } else if (text1.equals(getString(R.string.MCSL_045_title))) {
                Q1 = R.drawable.mcsl045_mca;
                Q2 = R.drawable.mcsl045_2_mca;
            } else if (text1.equals(getString(R.string.MCS_051_title))) {
                Q1 = R.drawable.mcs051_mca;
                Q2 = R.drawable.mcs051_2_mca;
            } else if (text1.equals(getString(R.string.MCS_052_title))) {
                Q1 = R.drawable.mcs052_mca;
                Q2 = R.drawable.mcs052_2_mca;
            } else if (text1.equals(getString(R.string.MCS_053_title))) {
                Q1 = R.drawable.mcs053_mca;
                Q2 = R.drawable.mcs053_2_mca;
            } else if (text1.equals(getString(R.string.MCSL_054_title))) {
                Q1 = R.drawable.mcsl054_mca;
                Q2 = R.drawable.mcsl054_2_mca;
            } else if (text1.equals(getString(R.string.MCSE_003_title))) {
                Q1 = R.drawable.mcse003_mca;
                Q2 = R.drawable.mcse003_2_mca;
            } else if (text1.equals(getString(R.string.MCSE_004_title))) {
                Q1 = R.drawable.mcse004_mca;
                Q2 = R.drawable.mcse004_2_mca;
            } else if (text1.equals(getString(R.string.MCSE_011_title))) {
                Q1 = R.drawable.mcse011_mca;
                Q2 = R.drawable.mcse011_2_mca;
            }

            else if (text1.equals(getString(R.string.MCS_011_title))) {
                Q1 = R.drawable.mcse011_mca;
                Q2 = R.drawable.mcse011_2_mca;
            } else if (text1.equals(getString(R.string.MCS_012_title))) {
                Q1 = R.drawable.mcs012_mca;
                Q2 = R.drawable.mcs012_2_mca;
            } else if (text1.equals(getString(R.string.MCS_015_title))) {
                Q1 = R.drawable.mcs015_mca;
                Q2 = R.drawable.mcs015_2_mca;
            } else if (text1.equals(getString(R.string.MCS_013_title))) {
                Q1 = R.drawable.mcs013_mca;
                Q2 = R.drawable.mcs013_2_mca;
            } else if (text1.equals(getString(R.string.MCS_021_title))) {
                Q1 = R.drawable.mcs021_mca;
                Q2 = R.drawable.mcs021_2_mca;
            } else if (text1.equals(getString(R.string.MCS_023_title))) {
                Q1 = R.drawable.mcs023_mca;
                Q2 = R.drawable.mcs023_2_mca;
            } else if (text1.equals(getString(R.string.MCS_014_title))) {
                Q1 = R.drawable.mcs014_mca;
                Q2 = R.drawable.mcs014_2_mca;
            }  else if (text1.equals(getString(R.string.MCS_024_title))) {
                Q1 = R.drawable.mcs024_mca;
                Q2 = R.drawable.mcs024_2_mca;
            } else if (text1.equals(getString(R.string.MCSL_016_title))) {
                Q1 = R.drawable.mcsl016_mca;
                Q2 = R.drawable.mcsl016_2_mca;
            } else if (text1.equals(getString(R.string.MCS_022_title))) {
                Q1 = R.drawable.mcs022_mca;
                Q2 = R.drawable.mcs022_2_mca;
            }

            else {
                Q1 = R.drawable.qn_null;
                Q2 = R.drawable.qn_null;
            }
        }else if (text2.equals(getString(R.string.course_ba))) {

                 b2.setVisibility(View.INVISIBLE);


            if (text1.equals(getString(R.string.FEG_01_title))) {
                Q1 = R.drawable.feg_01;
                Q2 = R.drawable.feg_01;
            } else if (text1.equals(getString(R.string.FST_01_title))) {
                Q1 = R.drawable.fst_01;
                Q2 = R.drawable.fst_01;
            }
            else if (text1.equals(getString(R.string.BHDF_01_title))) {
                Q1 = R.drawable.bhdf_101;
                Q2 = R.drawable.bhdf_101;
            }
            else if (text1.equals(getString(R.string.FHS_01_title))) {
                Q1 = R.drawable.fhs_01;
                Q2 = R.drawable.fhs_01;
            }
            else if (text1.equals(getString(R.string.FEG_02_title))) {
                Q1 = R.drawable.feg_02;
                Q2 =  R.drawable.feg_02;
            }
            else if (text1.equals(getString(R.string.FML_01_title))) {
                Q1 = R.drawable.fml_01;
                Q2 = R.drawable.fml_01;
            }
            else if (text1.equals(getString(R.string.BEGE_101_title))) {
                Q1 = R.drawable.bege_101;
                Q2 = R.drawable.bege_101;
            }
            else if (text1.equals(getString(R.string.EEG_02_title))) {
                Q1 = R.drawable.eeg_02;
                Q2 = R.drawable.eeg_02;
            }
            else if (text1.equals(getString(R.string.EEG_03_title))) {
                Q1 = R.drawable.eeg_03;
                Q2 = R.drawable.eeg_03;
            }
            else if (text1.equals(getString(R.string.EEG_04_title))) {
                Q1 = R.drawable.eeg_04;
                Q2 =  R.drawable.eeg_04;
            }
            else if (text1.equals(getString(R.string.EEG_05_title))) {
                Q1 = R.drawable.eeg_05;
                Q2 = R.drawable.eeg_05;
            }
            else if (text1.equals(getString(R.string.EEG_06_title))) {
                Q1 = R.drawable.eeg_06;
                Q2 = R.drawable.eeg_06;
            }
            else if (text1.equals(getString(R.string.EEG_07_title))) {
                Q1 = R.drawable.eeg_07;
                Q2 = R.drawable.eeg_07;
            }
            else if (text1.equals(getString(R.string.EEG_08_title))) {
                Q1 = R.drawable.eeg_08;
                Q2 = R.drawable.eeg_08;
            }
            else if (text1.equals(getString(R.string.AFW_E_title))) {
                Q1 = R.drawable.afw_e;
                Q2 = R.drawable.afw_e;
            }
            else if (text1.equals(getString(R.string.AWR_E_title))) {
                Q1 = R.drawable.awr_e;
                Q2 = R.drawable.awr_e;
            }
            else if (text1.equals(getString(R.string.AWR_H_title))) {
                Q1 = R.drawable.awr_h;
                Q2 = R.drawable.awr_h;
            } else {
                Q1 = R.drawable.qn_null;
                Q2 = R.drawable.qn_null;
            }

        }
        else {
            Q1 =R.drawable.qn_null;
            Q2 =R.drawable.qn_null;
        }


        sw.setImage(ImageSource.resource(Q1));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ButtonTone();
                Toasty.success(getBaseContext(), " 1 ", Toast.LENGTH_LONG, false).show();

                sw.setImage(ImageSource.resource(Q1));
                b1.setImageResource(R.drawable.one);


/* FAN



                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Check if interstitialAd has been loaded successfully
                        if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
                            return;
                        }
                        // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                        if(interstitialAd.isAdInvalidated()) {
                            return;
                        }
                        // Show the ad
                        interstitialAd.show();
                    }
                }, 1000);
*/

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTone();
               // Toast.makeText(getApplicationContext(), "2",Toast.LENGTH_SHORT).show();

                Toasty.success(getBaseContext(), " 2 ", Toast.LENGTH_LONG, false).show();

                sw.setImage(ImageSource.resource(Q2));


/* FAN
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Check if interstitialAd has been loaded successfully
                        if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
                            return;
                        }
                        // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                        if(interstitialAd.isAdInvalidated()) {
                            return;
                        }
                        // Show the ad
                        interstitialAd.show();
                    }
                }, 1000);

*/

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