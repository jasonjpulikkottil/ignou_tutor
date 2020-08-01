package com.jdots.ignou.login.view;

/**
 * Created for chatting on 27/07/16.
 */

public interface LoginDisplayer {

    void attach(LoginActionListener actionListener);

    void detach(LoginActionListener actionListener);

    void showAuthenticationError(String message);

    void showErrorFromResourcesString(int id);

    public interface LoginActionListener {

        void onGooglePlusLoginSelected();

        void onEmailAndPassLoginSelected(String email, String password);

        void onRegistrationSelected();

        void onForgotSelected();

    }

}