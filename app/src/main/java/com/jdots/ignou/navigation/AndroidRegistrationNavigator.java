package com.jdots.ignou.navigation;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created for chatting
 */

public class AndroidRegistrationNavigator implements RegistrationNavigator {

    private final AppCompatActivity activity;

    public AndroidRegistrationNavigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void toLogin() {
        activity.finish();
    }

    @Override
    public void toMainActivity() {

    }

    @Override
    public void toParent() {

    }

    @Override
    public void attach(RegistrationResultListener registrationResultListener) {
    }

    @Override
    public void detach(RegistrationResultListener registrationResultListener) {
    }
}
