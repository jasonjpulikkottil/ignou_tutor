package com.jdots.ignou.global.database;

import com.jdots.ignou.global.data_model.Chat;
import com.jdots.ignou.global.data_model.Message;

import rx.Observable;

/**
 * Created for chatting on 08/08/16.
 */

public interface GlobalDatabase {

    Observable<Chat> observeOldMessages(String key);

    Observable<Message> observeNewMessages(String key);

    Observable<Chat> observeChat();

    void sendMessage(Message message);

}

