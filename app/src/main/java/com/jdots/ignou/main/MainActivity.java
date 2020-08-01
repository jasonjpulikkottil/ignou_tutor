package com.jdots.ignou.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.jdots.ignou.BaseActivity;
import com.jdots.ignou.Dependencies;
import com.jdots.ignou.Main;
import com.jdots.ignou.R;
import com.jdots.ignou.WebActivity;
import com.jdots.ignou.main.presenter.MainPresenter;
import com.jdots.ignou.main.view.MainDisplayer;
import com.jdots.ignou.navigation.AndroidMainNavigator;

import es.dmoral.toasty.Toasty;

/**
 * Created for chatting on 14/08/16.
 */

public class MainActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener {

    private MainPresenter presenter;
    private AndroidMainNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatmain);
        MainDisplayer mainDisplayer = (MainDisplayer) findViewById(R.id.mainView);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();

        navigator = new AndroidMainNavigator(this, googleApiClient);
        presenter = new MainPresenter(
                Dependencies.INSTANCE.getLoginService(),
                Dependencies.INSTANCE.getUserService(),
                mainDisplayer,
                Dependencies.INSTANCE.getMainService(),
                Dependencies.INSTANCE.getMessagingService(),
                navigator,
                Dependencies.INSTANCE.getFirebaseToken(),
                this
                );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!navigator.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (!presenter.onBackPressed())
            if (!navigator.onBackPressed()) {
try {
    Intent i = new Intent(MainActivity.this, Main.class);
    startActivity(i);
}catch(Exception e)
{
    Toasty.error(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG, false).show();

}
                super.onBackPressed();
            }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // DO SOMETHING
    }

}

