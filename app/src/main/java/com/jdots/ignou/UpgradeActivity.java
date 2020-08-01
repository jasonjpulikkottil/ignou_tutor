package com.jdots.ignou;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.preference.PreferenceManager;

import android.os.Vibrator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import in.myinnos.library.AppIconNameChanger;

public class UpgradeActivity extends AppCompatActivity implements View.OnClickListener {


  BillingProcessor bp;

    // PRODUCT & SUBSCRIPTION IDS

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


        new AppIconNameChanger.Builder(UpgradeActivity.this)
                .activeName(activeName) // String
                .disableNames(disableNames) // List<String>
                .packageName(BuildConfig.APPLICATION_ID)
                .build()
                .setNow();

    }



    public void purchaseUpdate() {

        Button B1 = findViewById(R.id.buttonAdfree);
        Button B2 = findViewById(R.id.buttonPro);

        TextView T1 = findViewById(R.id.textViewAdfree);
        TextView T2 = findViewById(R.id.textViewPro);

        bp.loadOwnedPurchasesFromGoogle();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		prefs.edit().putBoolean("PRODUCT_PRO", false).apply();
		prefs.edit().putBoolean("PRODUCT_ADFREE", false).apply();


		if(bp.isPurchased(getString(R.string.PRODUCT_ID_A))) {
            prefs.edit().putBoolean("PRODUCT_ADFREE", true).apply();

            B1.setVisibility(View.GONE);

            T1.setText(getString(R.string.adfree_text_purchased));
            changeAppName("ADFREE");



        }else
        {

            T1.setText(getString(R.string.adfree_text));

                B1.setVisibility(View.VISIBLE);
        }

        if(bp.isPurchased(getString(R.string.PRODUCT_ID_B))) {
            prefs.edit().putBoolean("PRODUCT_PRO", true).apply();


            B2.setVisibility(View.GONE);
            T2.setText(getString(R.string.pro_text_purchased));
            changeAppName("PRO");

        }else
        {
            B2.setVisibility(View.VISIBLE);
            T2.setText(getString(R.string.pro_text));

        }

        if(bp.isPurchased(getString(R.string.PRODUCT_ID_B))||bp.isPurchased(getString(R.string.PRODUCT_ID_A)) )
        {
            prefs.edit().putBoolean("NOADS", true).apply();
        }
        else
        {
            prefs.edit().putBoolean("NOADS", false).apply();
        }



        // Toast(String.format("%s is%s purchased", PRODUCT_ID_B, bp.isPurchased(PRODUCT_ID_B) ? "" : " not"));
		//Toast(String.format("%s is%s purchased", PRODUCT_ID_A, bp.isPurchased(PRODUCT_ID_A) ? "" : " not"));

    }
    public void ButtonSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        Vibrator vib = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(50);
        SharedPreferences pref = android.preference.PreferenceManager.getDefaultSharedPreferences(this);
        if (pref.getBoolean("switch_sounds", true)) {
            mp.start();
        }
    }
	@Override
	protected void onResume() {

        super.onResume();
        purchaseUpdate();
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);



        Button B1 = findViewById(R.id.buttonAdfree);
        B1.setOnClickListener(this);
        Button B2 = findViewById(R.id.buttonPro);
        B2.setOnClickListener(this);

        if(!BillingProcessor.isIabServiceAvailable(this)) {
                Toast("In-app billing service is unavailable, please upgrade Android Market/Play to version >= 3.9.16");
            }

            bp = new BillingProcessor(this, getString(R.string.LICENSE_KEY), getString(R.string.MERCHANT_ID), new BillingProcessor.IBillingHandler() {
                @Override
                public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
                    Toast("Product Purchased: " + productId);
                    purchaseUpdate();
                }
                @Override
                public void onBillingError(int errorCode, @Nullable Throwable error) {
                   Toast("Billing Error: " + Integer.toString(errorCode));
                }
                @Override
                public void onBillingInitialized() {
                 // Toast("onBillingInitialized");
                    purchaseUpdate();
                }
                @Override
                public void onPurchaseHistoryRestored() {
                   // Toast("onPurchaseHistoryRestored");
                    for(String sku : bp.listOwnedProducts())
                        Toast( "Owned Managed Product: " + sku);

                    purchaseUpdate();
                }
            });


            bp.initialize();


    }
    private void Toast(String message) {

        Toasty.info(getBaseContext(), message, Toast.LENGTH_LONG, false).show();

    }

    @Override
    public void onClick(View v) {

       ButtonSound();


        switch (v.getId()) {

            case (R.id.buttonAdfree):
                bp.purchase(this,getString(R.string.PRODUCT_ID_A));
                break;
            case (R.id.buttonPro):
                bp.purchase(this,getString(R.string.PRODUCT_ID_B));
                break;

        }
    }

    @Override
    protected void onDestroy() {

        if (bp != null)
        {
            bp.release();

        }
        super.onDestroy();
    }
}
