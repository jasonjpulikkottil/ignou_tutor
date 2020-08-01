package com.jdots.ignou.user.service;

import com.jdots.ignou.user.data_model.User;
import com.jdots.ignou.user.data_model.Users;

import rx.Observable;

/**
 * Created for chatting on 31/07/16.
 */

public interface UserService {

    Observable<Users> syncUsers();

    Observable<User> getUser(String userId);

    Observable<Users> getUsers();

    void setName(User user, String name);

    void setProfileImage(User user, String image);

}