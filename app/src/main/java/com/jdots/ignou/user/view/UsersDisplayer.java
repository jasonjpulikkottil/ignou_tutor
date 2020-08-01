package com.jdots.ignou.user.view;

import com.jdots.ignou.user.data_model.User;
import com.jdots.ignou.user.data_model.Users;

/**
 * Created for chatting on 01/09/16.
 */

public interface UsersDisplayer {

    void display(Users users);

    void attach(UserInteractionListener userInteractionListener);

    void detach(UserInteractionListener userInteractionListener);

    interface UserInteractionListener {

        void onUserSelected(User user);

    }

    void filter(String text);

}
