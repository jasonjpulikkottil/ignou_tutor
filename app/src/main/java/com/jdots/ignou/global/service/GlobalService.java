package com.jdots.ignou.global.service;

import com.jdots.ignou.database.DatabaseResult;
import com.jdots.ignou.global.data_model.Chat;
import com.jdots.ignou.global.data_model.Message;

import rx.Observable;

/**
 * Created for chatting on 08/08/16.
 */

public interface GlobalService {

    Observable<Chat> getOldMessages(String key);

    Observable<Message> getNewMessages(String key);

    Observable<DatabaseResult<Chat>> getChat();

    void sendMessage(Message message);

}
