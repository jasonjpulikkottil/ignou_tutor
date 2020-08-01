package com.jdots.ignou.user.service;

import com.jdots.ignou.user.data_model.User;
import com.jdots.ignou.user.data_model.Users;
import com.jdots.ignou.user.database.UserDatabase;

import rx.Observable;

/**
 * Created for chatting on 31/07/16.
 */

public class PersistedUserService implements UserService {

    private final UserDatabase userDatabase;

    public PersistedUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public Observable<Users> syncUsers() {
        return userDatabase.observeUsers();
    }

    @Override
    public Observable<User> getUser(String userId) {
        return userDatabase.observeUser(userId);
    }

    @Override
    public Observable<Users> getUsers() {
        return userDatabase.singleObserveUsers();
    }

    @Override
    public void setName(User user, String name) {
        userDatabase.setUserName(user.getUid(),name);
    }

    @Override
    public void setProfileImage(User user, String image) {
        userDatabase.setUserImage(user.getUid(),image);
    }

}
