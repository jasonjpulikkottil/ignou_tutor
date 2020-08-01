package com.jdots.ignou.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jdots.ignou.Dependencies;
import com.jdots.ignou.R;
import com.jdots.ignou.conversation_list.ConversationListFragment;
import com.jdots.ignou.global.GlobalFragment;
import com.jdots.ignou.login.LoginActivity;
import com.jdots.ignou.firstlogin.UserFirstLoginActivity;
import com.jdots.ignou.profile.ProfileActivity;
import com.jdots.ignou.user.UsersFragment;

import static android.app.Activity.RESULT_OK;

/**
 * Created for chatting on 16/08/16.
 */

public class AndroidMainNavigator implements MainNavigator {

    private static final String TAG = AndroidMainNavigator.class.getSimpleName();
    private static final int REQUEST_INVITE = 1;
    public static final int LOGOUT_GOOGLE = 1;

    private boolean doubleBackToExitPressedOnce = false;
    private boolean firstOpen = true;

    private final AppCompatActivity activity;
    private final GoogleApiClient googleApiClient;

    private MaterialDialog progressDialog;

    public AndroidMainNavigator(AppCompatActivity activity, @Nullable GoogleApiClient googleApiClient) {
        this.activity = activity;
        this.googleApiClient = googleApiClient;
    }


    @Override
    public void attach() {

    }

    @Override
    public void detach() {

    }

    @Override
    public void init() {
        if (firstOpen) {
            this.toGlobalRoom();
            firstOpen = false;
        }
    }

    @Override
    public void toConversations() {
        ConversationListFragment conversationsFragment = new ConversationListFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,conversationsFragment)
                .commit();
    }

    @Override
    public void toGlobalRoom() {
        GlobalFragment globalFragment = new GlobalFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,globalFragment)
                .commit();
    }

    @Override
    public void toUserList() {
        UsersFragment usersFragment = new UsersFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,usersFragment)
                .commit();
    }

    @Override
    public void toInvite() {
        Intent intent = new AppInviteInvitation.IntentBuilder(activity.getString(R.string.main_invite_title))
                .setMessage(activity.getString(R.string.main_invite_message))
                .setCallToActionText(activity.getString(R.string.main_invite_cta))
                .build();
        activity.startActivityForResult(intent, REQUEST_INVITE);
    }

    @Override
    public void toProfile() {
        activity.startActivity(new Intent(activity,ProfileActivity.class));
    }

    @Override
    public void toFirstLogin() {
        activity.startActivity(new Intent(activity,UserFirstLoginActivity.class));
    }

    @Override
    public void toGoogleSignOut(int method) {
        Toast.makeText(activity,R.string.main_toast_logout_message,Toast.LENGTH_LONG).show();
        if (method == LOGOUT_GOOGLE) {
            Auth.GoogleSignInApi.signOut(googleApiClient);
        }
    }

    @Override
    public void toLogin() {
        Dependencies.INSTANCE.clearDependecies();
        activity.startActivity(new Intent(activity,LoginActivity.class));
    }

    @Override
    public void showProgessDialog() {
        progressDialog = new MaterialDialog.Builder(activity)
                .content(R.string.main_dialog_text_wait)
                .progress(true, 0)
                .show();
    }

    @Override
    public void hideProgessDialog() {
        progressDialog.dismiss();
    }

    @Override
    public Boolean onBackPressed() {
        if (doubleBackToExitPressedOnce)
            activity.finishAffinity();

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(activity, R.string.main_toast_exit_message, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
        return true;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Use Firebase Measurement to log that invitation was sent.
                Bundle payload = new Bundle();
                payload.putString(FirebaseAnalytics.Param.VALUE, "inv_sent");

                // Check how many invitations were sent and log.
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                Log.d(TAG, "Invitations sent: " + ids.length);
            } else {
                // Use Firebase Measurement to log that invitation was not sent
                Bundle payload = new Bundle();
                payload.putString(FirebaseAnalytics.Param.VALUE, "inv_not_sent");

                // Sending failed or it was canceled, show failure message to the user
                Log.d(TAG, "Failed to send invitation.");
            }
            return true;
        } else
            return false;
    }
}
