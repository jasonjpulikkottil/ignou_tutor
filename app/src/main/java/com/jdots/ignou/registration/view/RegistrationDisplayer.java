package com.jdots.ignou.registration.view;

/**
 * Created for chatting
 */

public interface RegistrationDisplayer {

    void attach(RegistrationActionListener actionListener);

    void detach(RegistrationActionListener actionListener);

    void showRegistrationAlertDialog(int id);

    void showErrorFromResourcesString(int id);

    public interface RegistrationActionListener {

        void onRegistrationSubmit(String email, String password, String confirm);

        void onLoginSelected();

        void onAlertDialogDismissed();

    }

}
