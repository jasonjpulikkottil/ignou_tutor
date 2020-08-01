package com.jdots.ignou;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.jdots.ignou.analytics.Analytics;
import com.jdots.ignou.analytics.FirebaseAnalyticsAnalytics;
import com.jdots.ignou.conversation.database.FirebaseConversationDatabase;
import com.jdots.ignou.conversation.service.ConversationService;
import com.jdots.ignou.conversation.service.PersistedConversationService;
import com.jdots.ignou.conversation_list.database.FirebaseConversationListDatabase;
import com.jdots.ignou.conversation_list.service.ConversationListService;
import com.jdots.ignou.conversation_list.service.PersistedConversationListService;
import com.jdots.ignou.global.database.FirebaseGlobalDatabase;
import com.jdots.ignou.global.service.GlobalService;
import com.jdots.ignou.global.service.PersistedGlobalService;
import com.jdots.ignou.login.database.FirebaseAuthDatabase;
import com.jdots.ignou.login.service.FirebaseLoginService;
import com.jdots.ignou.login.service.LoginService;
import com.jdots.ignou.main.database.FirebaseCloudMessagingDatabase;
import com.jdots.ignou.main.service.CloudMessagingService;
import com.jdots.ignou.main.service.FirebaseCloudMessagingService;
import com.jdots.ignou.main.service.MainService;
import com.jdots.ignou.main.service.PersistedMainService;
import com.jdots.ignou.profile.service.FirebaseProfileService;
import com.jdots.ignou.profile.service.ProfileService;
import com.jdots.ignou.registration.service.FirebaseRegistrationService;
import com.jdots.ignou.registration.service.RegistrationService;
import com.jdots.ignou.rx.FirebaseObservableListeners;
import com.jdots.ignou.storage.FirebaseStorageService;
import com.jdots.ignou.storage.StorageService;
import com.jdots.ignou.user.database.FirebaseUserDatabase;
import com.jdots.ignou.user.service.PersistedUserService;
import com.jdots.ignou.user.service.UserService;

/**
 * Created for chatting on 27/07/16.
 */

public enum Dependencies {
    INSTANCE;

    private Analytics analytics;
    private RegistrationService registrationService;
    private LoginService loginService;
    private ConversationListService conversationListService;
    private ConversationService conversationService;
    private GlobalService globalService;
    private UserService userService;
    private MainService mainService;
    private ProfileService profileService;
    private CloudMessagingService messagingService;
    private StorageService storageService;
    private String firebaseToken;
    //private Config config;

    private boolean setPersistence = false;

    public void init(Context context) {
        if (needsInitialisation()) {
            Context appContext = context.getApplicationContext();
            //FirebaseApp firebaseApp = FirebaseApp.initializeApp(appContext, FirebaseOptions.fromResource(appContext), "ChatFire");
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseToken = FirebaseInstanceId.getInstance().getToken();
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//            if (!setPersistence) {
//                FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//                setPersistence = true;
//            }
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            FirebaseObservableListeners firebaseObservableListeners = new FirebaseObservableListeners();
            FirebaseUserDatabase userDatabase = new FirebaseUserDatabase(firebaseDatabase, firebaseObservableListeners);
            FirebaseCloudMessagingDatabase messagingDatabase = new FirebaseCloudMessagingDatabase(firebaseDatabase, firebaseObservableListeners, firebaseToken);
            FirebaseConversationDatabase conversationDatabase = new FirebaseConversationDatabase(firebaseDatabase, firebaseObservableListeners);
            FirebaseConversationListDatabase conversationListDatabase = new FirebaseConversationListDatabase(firebaseDatabase,firebaseObservableListeners);

            analytics = new FirebaseAnalyticsAnalytics(FirebaseAnalytics.getInstance(appContext));
            loginService = new FirebaseLoginService(new FirebaseAuthDatabase(firebaseAuth),messagingDatabase);
            registrationService = new FirebaseRegistrationService(firebaseAuth);
            conversationService = new PersistedConversationService(conversationDatabase);
            globalService = new PersistedGlobalService(new FirebaseGlobalDatabase(firebaseDatabase, firebaseObservableListeners));
            userService = new PersistedUserService(userDatabase);
            conversationListService = new PersistedConversationListService(conversationListDatabase,conversationDatabase,userDatabase);
            mainService = new PersistedMainService(firebaseAuth, userDatabase, messagingDatabase);
            profileService = new FirebaseProfileService(firebaseAuth);

            messagingService = new FirebaseCloudMessagingService(messagingDatabase);
            storageService = new FirebaseStorageService(firebaseStorage,firebaseObservableListeners);
//            config = FirebaseConfig.newInstance().init(errorLogger);
        }
    }

    public void clearDependecies() {
        loginService = null;
        conversationListService = null;
        conversationService = null;
        userService = null;
    }

    private boolean needsInitialisation() {
        return loginService == null || conversationListService == null || conversationService == null || registrationService == null
                || userService == null;// || analytics == null || errorLogger == null;
    }

   /* public Analytics getAnalytics() {
        return analytics;
    }*/

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void initFirebaseToken() {
        firebaseToken = FirebaseInstanceId.getInstance().getToken();
    }

    public MainService getMainService() {
        return mainService;
    }

    public CloudMessagingService getMessagingService() {
        return messagingService;
    }

    public GlobalService getGlobalService() {
        return globalService;
    }

    public ConversationService getConversationService() {
        return conversationService;
    }

    public ConversationListService getConversationListService() {
        return conversationListService;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public UserService getUserService() {
        return userService;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    /*
    public Config getConfig() {
        return config;
    }*/
}
