package com.jdots.ignou.conversation_list.service;

import com.jdots.ignou.conversation.data_model.Message;
import com.jdots.ignou.conversation.database.ConversationDatabase;
import com.jdots.ignou.conversation_list.database.ConversationListDatabase;
import com.jdots.ignou.user.data_model.User;
import com.jdots.ignou.user.data_model.Users;
import com.jdots.ignou.user.database.UserDatabase;

import java.util.List;

import rx.Observable;

/**
 * Created for chatting on 29/07/16.
 */

public class PersistedConversationListService implements  ConversationListService {

    private final ConversationListDatabase conversationListDatabase;
    private final ConversationDatabase conversationDatabase;
    private final UserDatabase userDatabase;

    public PersistedConversationListService(ConversationListDatabase conversationListDatabase, ConversationDatabase conversationDatabase, UserDatabase userDatabase) {
        this.conversationListDatabase = conversationListDatabase;
        this.conversationDatabase = conversationDatabase;
        this.userDatabase = userDatabase;
    }

    @Override
    public Observable<Message> getLastMessageFor(User self, User destination) {
        return conversationDatabase.observeLastMessage(self.getUid(),destination.getUid());
    }

    @Override
    public Observable<List<String>> getConversationsFor(User user) {
        return conversationListDatabase.observeConversationsFor(user);
    }

    @Override
    public Observable<Users> getUsers(List<String> usersId) {
        return userDatabase.singleObserveUsers();
    }

}
