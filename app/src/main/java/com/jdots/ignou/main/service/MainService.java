package com.jdots.ignou.main.service;

import com.jdots.ignou.user.data_model.User;

/**
 * Created for chatting on 16/08/16.
 */

public interface MainService {

    String getLoginProvider() throws Exception;

    void initLastSeen(User user);

    void logout();

}
