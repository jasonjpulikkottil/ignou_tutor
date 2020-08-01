package com.jdots.ignou.conversation.database;

import com.jdots.ignou.conversation.data_model.Chat;
import com.jdots.ignou.conversation.data_model.Message;

import rx.Observable;

/**
 * Created for chatting on 29/07/16.
 */

public interface ConversationDatabase {

    Observable<Chat> observeOldMessages(String self, String destination, String key);

    Observable<Message> observeNewMessages(String self, String destination, String key);

    Observable<Message> observeLastMessage(String self, String destination);

    Observable<Chat> observeChat(String self, String destination);

    void sendMessage(String user, Message message);

    Observable<Boolean> observeTyping(String self, String destination);

    void setTyping(String self, String destination, Boolean value);

}
