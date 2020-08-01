package com.jdots.ignou;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.jdots.ignou.login.LoginActivity;

import net.khirr.android.privacypolicy.PrivacyPolicyDialog;


import java.util.ArrayList;
import java.util.List;

import angtrim.com.fivestarslibrary.FiveStarsDialog;
import es.dmoral.toasty.Toasty;
import in.myinnos.library.AppIconNameChanger;
import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;

import static com.jdots.ignou.MaterialActivity.TOKEN3;


public class Main extends AppCompatActivity implements View.OnClickListener  {

    public static final String TOKEN4 = "com.jdots.TOKEN4";
    public String SwitchText;

    AdView adView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(Main.this, SettingsActivity.class);
                startActivity(i);
                return true;


            case R.id.action_about:

                AboutBox();

                return true;
            case R.id.action_chlog:


                ImageView img = new ImageView(this);
                img.setImageResource(R.drawable.about);

                AlertDialog.Builder br =
                        new AlertDialog.Builder(this)

                                .setView(img)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                AlertDialog alertDialog = br.create();
                alertDialog.show();
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                try {
                    int orientation = getResources().getConfiguration().orientation;

                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        width = size.x/2;
                        height = size.x * 3 / 4;
                    }

                    alertDialog.getWindow().setLayout(width * 3 / 4, height / 2);
                }catch(Exception ignored){}

                return true;


            case R.id.action_fb:

                Intent k = new Intent(Main.this, WebActivity.class);
                String txt1 = "http://www.facebook.com/jdotslab";
                k.putExtra(TOKEN4, txt1);
                startActivity(k);
                return true;

            case R.id.action_web:

                Intent l = new Intent(Main.this, WebActivity.class);
                String txt2 = "http://jdotslab.ga";
                l.putExtra(TOKEN4, txt2);
                startActivity(l);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
 private void Toast(String message) {

     Toasty.info(getBaseContext(), message, Toast.LENGTH_LONG, false).show();



     //   bp.purchase(this,PRODUCT_ID_B);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);

            adjusttheme();

            setContentView(R.layout.activity_main);


            AudienceNetworkAds.initialize(this);



            Privacy();
            if (getUseCount(false) > 2) welcomemsg();


            FabSpeedDial fabSpeedDial = (FabSpeedDial) findViewById(R.id.FABspeed);

            fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
                @Override
                public boolean onMenuItemSelected(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {

                        case R.id.fab_feedback:
                            sendFeed();
                            return true;
                        case R.id.fab_note:
                            sendNote();
                            return true;
                        case R.id.fab_share:
                            shareLink();
                            return true;


                    }
                    return false;
                }
            });



            final AppUpdater appUpdater = new AppUpdater(this)
                    .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                    .setCancelable(true)
                    .setIcon(R.drawable.jdots)
                    .setButtonDoNotShowAgain(null)
                    .setTitleOnUpdateAvailable("UNINSTALL THIS APP AND INSTALL THE UPDATE");
            //.setContentOnUpdateAvailable("Uninstall this version and install the new version");
            appUpdater.setButtonDismissClickListener(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toasty.info(getBaseContext(), "You may use new version of the app IGNOU Tutor", Toast.LENGTH_LONG, true).show();
                    //finish();
                }
            });

            appUpdater.start();


            FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this, "admin@jdotslab.ga");
            fiveStarsDialog.setRateText("Rating 5 stars will increase future app developments")
                    .setTitle("Rate IGNOU Tutor")
                    .setForceMode(true)
                    .setUpperBound(4)
                    .showAfter(7);


            Intent intent1 = new Intent(getApplicationContext(), this.getClass());
            PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), intent1, 0);
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            if (pref.getBoolean("notifications_new_message", true)) {
                scheduleNotification(getNotification("Learn with IGNOU Tutor", pIntent), 12000000);
                scheduleNotification(getNotification("Learn with IGNOU Tutor", pIntent), 2400000);
            }











            Button opt_1_1 = findViewById(R.id.optButton_1_1);
            opt_1_1.setOnClickListener(this);

            Button opt_1_2 = findViewById(R.id.optButton_1_2);
            opt_1_2.setOnClickListener(this);

            Button opt_1_3 = findViewById(R.id.optButton_1_3);
            opt_1_3.setOnClickListener(this);

            Button opt_1_4 = findViewById(R.id.optButton_1_4);
            opt_1_4.setOnClickListener(this);

            Button opt_1_5 = findViewById(R.id.optButton_1_5);
            opt_1_5.setOnClickListener(this);

            Button opt_1_6 = findViewById(R.id.optButton_1_6);
            opt_1_6.setOnClickListener(this);

            //

            Button opt_2_1 = findViewById(R.id.optButton_2_1);
            opt_2_1.setOnClickListener(this);

            Button opt_2_2 = findViewById(R.id.optButton_2_2);
            opt_2_2.setOnClickListener(this);

            Button opt_2_3 = findViewById(R.id.optButton_2_3);
            opt_2_3.setOnClickListener(this);

            Button opt_2_4 = findViewById(R.id.optButton_2_4);
            opt_2_4.setOnClickListener(this);

            //

            Button opt_3_1 = findViewById(R.id.optButton_3_1);
            opt_3_1.setOnClickListener(this);

            Button opt_3_2 = findViewById(R.id.optButton_3_2);
            opt_3_2.setOnClickListener(this);

            Button opt_3_3 = findViewById(R.id.optButton_3_3);
            opt_3_3.setOnClickListener(this);

            Button opt_3_4 = findViewById(R.id.optButton_3_4);
            opt_3_4.setOnClickListener(this);

            Button opt_3_5 = findViewById(R.id.optButton_3_5);
            opt_3_5.setOnClickListener(this);

            Button opt_3_6 = findViewById(R.id.optButton_3_6);
            opt_3_6.setOnClickListener(this);

            Button opt_3_7 = findViewById(R.id.optButton_3_7);
            opt_3_7.setOnClickListener(this);

            Button opt_3_8 = findViewById(R.id.optButton_3_8);
            opt_3_8.setOnClickListener(this);

            Button opt_3_9 = findViewById(R.id.optButton_3_9);
            opt_3_9.setOnClickListener(this);

            Button opt_3_10 = findViewById(R.id.optButton_3_10);
            opt_3_10.setOnClickListener(this);

            Button opt_3_11 = findViewById(R.id.optButton_3_11);
            opt_3_11.setOnClickListener(this);

            Button opt_3_12 = findViewById(R.id.optButton_3_12);
            opt_3_12.setOnClickListener(this);

            Button opt_3_13 = findViewById(R.id.optButton_3_13);
            opt_3_13.setOnClickListener(this);

            Button opt_3_14 = findViewById(R.id.optButton_3_14);
            opt_3_14.setOnClickListener(this);

            //

            Button opt_4_1 = findViewById(R.id.optButton_4_1);
            opt_4_1.setOnClickListener(this);

            Button opt_4_2 = findViewById(R.id.optButton_4_2);
            opt_4_2.setOnClickListener(this);

            Button opt_4_3 = findViewById(R.id.optButton_4_3);
            opt_4_3.setOnClickListener(this);

            Button opt_4_4 = findViewById(R.id.optButton_4_4);
            opt_4_4.setOnClickListener(this);

            Button opt_4_5 = findViewById(R.id.optButton_4_5);
            opt_4_5.setOnClickListener(this);

            Button opt_4_6 = findViewById(R.id.optButton_4_6);
            opt_4_6.setOnClickListener(this);

            Button opt_4_7 = findViewById(R.id.optButton_4_7);
            opt_4_7.setOnClickListener(this);

            Button opt_4_8 = findViewById(R.id.optButton_4_8);
            opt_4_8.setOnClickListener(this);

            Button opt_4_9 = findViewById(R.id.optButton_4_9);
            opt_4_9.setOnClickListener(this);

            Button opt_4_10 = findViewById(R.id.optButton_4_10);
            opt_4_10.setOnClickListener(this);

            Button opt_4_11 = findViewById(R.id.optButton_4_11);
            opt_4_11.setOnClickListener(this);

            Button opt_4_12 = findViewById(R.id.optButton_4_12);
            opt_4_12.setOnClickListener(this);


            //

            Button opt_5_1 = findViewById(R.id.optButton_5_1);
            opt_5_1.setOnClickListener(this);

            Button opt_5_2 = findViewById(R.id.optButton_5_2);
            opt_5_2.setOnClickListener(this);

            //

            Button opt_6_1 = findViewById(R.id.optButton_6_1);
            opt_6_1.setOnClickListener(this);

            Button opt_6_2 = findViewById(R.id.optButton_6_2);
            opt_6_2.setOnClickListener(this);

            Button opt_6_3 = findViewById(R.id.optButton_6_3);
            opt_6_3.setOnClickListener(this);

            Button opt_6_4 = findViewById(R.id.optButton_6_4);
            opt_6_4.setOnClickListener(this);

            Button opt_6_5 = findViewById(R.id.optButton_6_5);
            opt_6_5.setOnClickListener(this);

            Button opt_6_6 = findViewById(R.id.optButton_6_6);
            opt_6_6.setOnClickListener(this);

            Button opt_6_7 = findViewById(R.id.optButton_6_7);
            opt_6_7.setOnClickListener(this);

            Button opt_6_8 = findViewById(R.id.optButton_6_8);
            opt_6_8.setOnClickListener(this);

            Button opt_6_9 = findViewById(R.id.optButton_6_9);
            opt_6_9.setOnClickListener(this);

            Button opt_6_10 = findViewById(R.id.optButton_6_10);
            opt_6_10.setOnClickListener(this);

            Button opt_6_11 = findViewById(R.id.optButton_6_11);
            opt_6_11.setOnClickListener(this);

            //

            Button opt_7_1 = findViewById(R.id.optButton_7_1);
            opt_7_1.setOnClickListener(this);

            Button opt_7_2 = findViewById(R.id.optButton_7_2);
            opt_7_2.setOnClickListener(this);

            Button opt_7_3 = findViewById(R.id.optButton_7_3);
            opt_7_3.setOnClickListener(this);

            //

            Button opt_8_1 = findViewById(R.id.optButton_8_1);
            opt_8_1.setOnClickListener(this);

            Button opt_8_2 = findViewById(R.id.optButton_8_2);
            opt_8_2.setOnClickListener(this);

            Button opt_chat = findViewById(R.id.optButtonChat);
            opt_chat.setOnClickListener(this);

            Button opt_pro = findViewById(R.id.optButtonUp);
            opt_pro.setOnClickListener(this);



            final ExpansionLayout expansionLayout1 = findViewById(R.id.expansion_1);
            expansionLayout1.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout2 = findViewById(R.id.expansion_2);
            expansionLayout2.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout3 = findViewById(R.id.expansion_3);
            expansionLayout3.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout4 = findViewById(R.id.expansion_4);
            expansionLayout4.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout5 = findViewById(R.id.expansion_5);
            expansionLayout5.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout6 = findViewById(R.id.expansion_6);
            expansionLayout6.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout7 = findViewById(R.id.expansion_7);
            expansionLayout7.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                }
            });
            ExpansionLayout expansionLayout8 = findViewById(R.id.expansion_8);
            expansionLayout8.addListener(new ExpansionLayout.Listener() {
                @Override
                public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                    ButtonSound();
                    final ScrollView scr = (ScrollView) findViewById(R.id.MainScroll);
                    try {
                        scr.scrollBy(0, scr.getBottom());
                    } catch (Exception ignored) {
                    }
                }
            });

            final ExpansionLayoutCollection expansionLayoutCollection = new ExpansionLayoutCollection();
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_1));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_2));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_3));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_4));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_5));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_6));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_7));
            expansionLayoutCollection.add((ExpansionLayout) findViewById(R.id.expansion_8));
            expansionLayoutCollection.openOnlyOne(true);





            /**/
            mainPurchaseUpdate();
            /**/


        } catch (Exception e) {

            Toast(e.getMessage());
        }

    }




    @Override
    public void onClick(View v) {
Intent i;
String txt1;
String googleDocs = "https://docs.google.com/viewer?url=";

     ButtonSound();


switch (v.getId()) {




        case (R.id.optButtonUp):
            i = new Intent(Main.this, UpgradeActivity.class);
            startActivity(i);
        break;


        case (R.id.optButtonChat):
             i = new Intent(Main.this, LoginActivity.class);
             startActivity(i);
             break;

         case (R.id.optButton_1_1):
             i = new Intent(Main.this, MaterialActivity.class);
             startActivity(i);
             break;

         case (R.id.optButton_1_2):
             i = new Intent(Main.this, MCAMaterialActivity.class);
             startActivity(i);
             break;

         case (R.id.optButton_1_3):
             i = new Intent(Main.this, BAMaterialActivity.class);
             startActivity(i);
             break;

         case (R.id.optButton_1_4):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://jdotslab.ga/ignou/bcaquestion";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_1_5):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://jdotslab.ga/ignou/mcaquestion";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_1_6):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "https://webservices.ignou.ac.in/Pre-Question/";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_2_1):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in/handle/123456789/404";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_2_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in/handle/123456789/914";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_2_3):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in/handle/123456789/612";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_2_4):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in/handle/123456789/1";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_3_1):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Business organization";

             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_2):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "C language";

             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_3):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "C++ language";

             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_4):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "English grammar";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_5):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Java language";

             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_6):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Assembly programming and microprocessor";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_7):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Data communications and networks";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_8):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Data structures";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_9):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Database management system";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_10):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Internet technology";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_11):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Operating system";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_12):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Relational database management system";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_13):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Software engineering";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_3_14):
             i = new Intent(Main.this, DocviewActivity.class);
             SwitchText = "Software engineering 2";
             i.putExtra(TOKEN3, SwitchText);
             startActivity(i);
             break;

         case (R.id.optButton_4_1):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);


             break;

         case (R.id.optButton_4_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://admission.ignou.ac.in/changeadmdata/AdmissionStatusNew.asp";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_3):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in/ignou/studentzone/results/4";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_4):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "https://webservices.ignou.ac.in/assignments";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;
         case (R.id.optButton_4_5):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in/ignou/studentzone/downloads/3";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_6):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/ignou/studentzone";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_7):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_8):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/ignou/bulletinboard/";
                        /*
                        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
                        txt1="http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf;
                        */
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_9):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "https://exam.ignou.ac.in/search.asp";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;


         case (R.id.optButton_4_10):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "https://admission.ignou.ac.in/changeadmdata/StatusAssignment.ASP";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_11):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignourcd2.ac.in/Studymaterial.aspx";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_4_12):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/ignou/studentzone/results/2";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;


         case (R.id.optButton_5_1):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://jdotslab.ga/ignou/bca";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_5_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://jdotslab.ga/ignou/mca";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_1):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/TEE%20FORM.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Application%20form%20for%20Reevaluation%20of%20Answer%20Scripts(1).pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_3):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in/userfiles/Application%20form%20for%20Reimbursement%20of%20fee.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_4):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Duplicate%20Degree,Diploma%20and%20Certificate%20Form.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_5):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Duplicate%20mark%20sheet%20form.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_6):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Official%20Transcript%20form.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_7):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/APPLICATION%20FORM%20FOR%20EARLY%20DECLARATION%20OF%20RESULT%20OF%20TERM-END%20EXAMINATION.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_8):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Improvement%20form.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_9):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://www.ignou.ac.in/userfiles/Application%20Form%20for%20botaining%20photocopy%20of%20the%20answer%20script.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_10):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in/userfiles/Form%20for%20Change%20of%20Medium,%20Course%20of%20Study.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_6_11):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in/userfiles/Migration%20Certificate.pdf";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;


         case (R.id.optButton_7_1):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in//userfiles/Common-Prospectus-English.pdf";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_7_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in//userfiles/Common-Prospectus-Hindi.pdf";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;

         case (R.id.optButton_7_3):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://ignou.ac.in//userfiles/MBA%20Prospectus%202020.pdf";

             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;
         case (R.id.optButton_8_1):
             i = new Intent(Main.this, PuzzleActivity.class);
             startActivity(i);
             break;

         case (R.id.optButton_8_2):
             i = new Intent(Main.this, WebActivity.class);
             txt1 = "http://egyankosh.ac.in/handle/123456789/35748";
             i.putExtra(TOKEN4, txt1);
             startActivity(i);
             break;


         default:
             break;
     }

 }


/**/





    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public void onBackPressed() {
        //  if (mInterstitialAd.isLoaded())
        //  {
        //      mInterstitialAd.show();
        // } else
        // {
        // //    mInterstitialAd.loadAd(new AdRequest.Builder().build());
        // }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }



        super.onDestroy();
    }



    public void sendFeed() {
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(200);
try {
    Intent i = new Intent(Main.this, WebActivity.class);
    String txt1 = "https://drive.google.com/open?id=1j4h6Cd5A4r3Aw29nMNY74OtB-6M5t9IYKnwHj8sy14M";
    i.putExtra(TOKEN4, txt1);
    startActivity(i);
}catch(Exception e){
        Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
    }
    }

    public void shareLink() {
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(200);

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Download IGNOU Tutor");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Download IGNOU Tutor \nGet solved assignments , question banks , notes and many more.\n https://play.google.com/store/apps/details?id=com.jdots.ignou");
        startActivity(Intent.createChooser(sharingIntent, "Share"));

    }

    public void sendNote() {
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(200);
        Intent i = new Intent(Main.this, NoteListActivity.class);
        startActivity(i);

    }

    public void adjusttheme() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = prefs.getString("list_preference_theme", "1");
        switch (theme) {
            case ("Pink-Blue"):
                setTheme(R.style.AppTheme1);
                break;
            case ("Red-Blue"):
                setTheme(R.style.AppTheme2);
                break;
            case ("Blue-Green"):
                setTheme(R.style.AppTheme3);
                break;
            case ("Green-Red"):
                setTheme(R.style.AppTheme4);
                break;
            default:
                setTheme(R.style.AppTheme1);

        }
    }

    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content, PendingIntent P) {

        SharedPreferences prefer = PreferenceManager.getDefaultSharedPreferences(this);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Tap to open");
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.jdots);
        if (prefer.getBoolean("switch_sounds", true)) {
            builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        }
        builder.setContentIntent(P);
        return builder.build();
    }

    public void welcomemsg() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String def = getString(R.string.pref_default_display_name);
        String user = prefs.getString("user_text", def);
        if (/*user.equals(def) && */prefs.getBoolean("switch_chlog", true)) {

        TapTarget_Switch(4);
        }
        prefs.edit().putBoolean("switch_chlog", false).apply();

    }
    public int getUseCount(Boolean increment) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(increment)
        prefs.edit().putInt("use_count", prefs.getInt("use_count", 0)+1).apply();

       return (prefs.getInt("use_count", 0));
    }



    public void WelcomeBox() {

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.about);

        AlertDialog.Builder br =
                new AlertDialog.Builder(this)
                        .setView(img)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = br.create();
        alertDialog.show();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        try {
            int orientation = getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                width = size.x/2;
                height = size.x * 3 / 4;
            }

            alertDialog.getWindow().setLayout(width * 3 / 4, height / 2);
        }catch(Exception ignored){}
    }


    public void AboutBox() {
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.jdotslab);

        AlertDialog.Builder br =
                new AlertDialog.Builder(this)
                        .setView(img)

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

        AlertDialog alertDialog = br.create();
        alertDialog.show();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        try {
            int orientation = getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                width = size.x/2;
                height = size.x * 3 / 4;
            }

            alertDialog.getWindow().setLayout(width * 3 / 4, height / 2);
        }catch(Exception ignored){}

    }
	public String getVersionName(){
    String version="2.0";
    try {
        PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
        version = pInfo.versionName;
    } catch (PackageManager.NameNotFoundException ignored) {    }
    return version;
}
    public void ButtonSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(50);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (pref.getBoolean("switch_sounds", true)) {
            mp.start();
        }
    }
    public void Privacy()
    {
        PrivacyPolicyDialog dialog;
        final Intent intent = new Intent(this, Main.class);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        dialog = new PrivacyPolicyDialog(this,
                "https://ignou-tutor.flycricket.io/", "https://ignou-tutor.flycricket.io/privacy.html");
        dialog.addPoliceLine("This application uses a unique user identifier for advertising purposes, it is shared with third-party companies.");
        dialog.addPoliceLine("This application sends error reports, installation and send it to a server of the Fabric.io company to analyze and process it.");
        dialog.addPoliceLine("All details about the use of data are available in our Privacy Policies, as well as all Terms of Service links below.");


        dialog.setTitleTextColor(Color.parseColor("#2222FF"));
        dialog.setAcceptButtonColor(ContextCompat.getColor(this, R.color.colorAccent));
        dialog.show();


        dialog.setOnClickListener(new PrivacyPolicyDialog.OnClickListener() {
            @Override
            public void onAccept(boolean isFirstTime) {
                Log.e("Main", "Policies accepted");
              //  startActivity(intent);
              //  finish();
                welcomemsg();

            }

            @Override
            public void onCancel() {
                Log.e("Main", "Policies not accepted");
                Toasty.error(getBaseContext(), "Policies not accepted", Toast.LENGTH_LONG, true).show();

                    prefs.edit().putBoolean("switch_chlog", true).apply();

                    prefs.edit().putInt("use_count", 0).apply();



                finish();
            }
        });
    }
    public void TapTarget(final int ID, final String TITLE, final String DESCRIPTION, final int ITER)
    {

        TapTargetView.showFor(this, TapTarget.forView(findViewById(ID), TITLE, DESCRIPTION)
                        // All options below are optional
                        .outerCircleColor(R.color.TransGreen)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.8f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.TransBlue)   // Specify a color for the target circle
                        .titleTextSize(22)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.colorAccent3)      // Specify the color of the title text
                        .descriptionTextSize(17)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.Red)   // Specify the color of the description text
                        .textColor(R.color.Red)          // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        //.dimColor(R.color.colorAccent3)             // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(false)                    // Specify a custom drawable to draw as the target
                        .targetRadius(60),                  // Specify the target radius (in dp)
                new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional

                        TapTarget_Switch(ITER-1);

                    }
                });

    }

    public void TapTarget_Switch(int i)
    {


        switch (i)
        {
            case 4:
                TapTarget(R.id.exHeader_1,"Select a Topic","Choose a course",i);
                break;
            case 3:
                TapTarget(R.id.FABspeed,"Access Speed Dial","Send Feedback , Add Note or Share App",i);
                break;
            case 2:
                TapTarget(R.id.optButtonUp,"Upgrade App","Upgrade to PRO or ADFREE version",i);
                break;

            default:break;

        }
    }




    public void mainPurchaseUpdate() {

        SharedPreferences prefs = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

        Button optUp = findViewById(R.id.optButtonUp);
        Button optChat = findViewById(R.id. optButtonChat);


try {

    BillingProcessor bp = new BillingProcessor(this, getString(R.string.LICENSE_KEY), getString(R.string.MERCHANT_ID), new BillingProcessor.IBillingHandler() {
        @Override
        public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {

        }

        @Override
        public void onBillingError(int errorCode, @Nullable Throwable error) {
        }

        @Override
        public void onBillingInitialized() {

        }

        @Override
        public void onPurchaseHistoryRestored() {

        }
    });
    bp.initialize();
    bp.loadOwnedPurchasesFromGoogle();

    if (bp.isPurchased(getString(R.string.PRODUCT_ID_A))) {
        prefs.edit().putBoolean("PRODUCT_ADFREE", true).apply();
        changeAppName("ADFREE");

    }
    if (bp.isPurchased(getString(R.string.PRODUCT_ID_B))) {
        prefs.edit().putBoolean("PRODUCT_PRO", true).apply();
        changeAppName("PRO");
    }
    if(bp.isPurchased(getString(R.string.PRODUCT_ID_B))||bp.isPurchased(getString(R.string.PRODUCT_ID_A)) )
    {
        prefs.edit().putBoolean("NOADS", true).apply();
    }
    else
    {
        prefs.edit().putBoolean("NOADS", false).apply();
    }
    if (prefs.getBoolean("PRODUCT_PRO", false)) //PRO
    {
        optUp.setVisibility(View.GONE);
        optChat.setVisibility(View.VISIBLE);
    } else                                                          // NON - PRO
    {
        optUp.setVisibility(View.VISIBLE);
        optChat.setVisibility(View.GONE);

    }

} catch (Exception e) {

    Toast(e.getMessage());
}
    }

    public void changeAppName(String TYPE){
        List<String> disableNames = new ArrayList<String>();
        String activeName= "com.jdots.ignou.Splash";
        if(TYPE=="PRO")
        {
            activeName = "com.jdots.ignou.Pro";
            disableNames.add("com.jdots.ignou.Adfree");
            disableNames.add( "com.jdots.ignou.Splash");
        }else if(TYPE=="ADFREE")
        {
            activeName = "com.jdots.ignou.Adfree";
            disableNames.add("com.jdots.ignou.Pro");
            disableNames.add( "com.jdots.ignou.Splash");
        }
        else
        {
            activeName = "com.jdots.ignou.Splash";
            disableNames.add("com.jdots.ignou.Adfree");
            disableNames.add("com.jdots.ignou.Pro");
        }


        new AppIconNameChanger.Builder(Main.this)
                .activeName(activeName) // String
                .disableNames(disableNames) // List<String>
                .packageName(BuildConfig.APPLICATION_ID)
                .build()
                .setNow();

    }
}

