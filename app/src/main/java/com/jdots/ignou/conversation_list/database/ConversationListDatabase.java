package com.jdots.ignou.conversation_list.database;

import com.jdots.ignou.user.data_model.User;

import java.util.List;

import rx.Observable;

/**
 * Created for chatting on 29/07/16.
 */

public interface ConversationListDatabase {

    Observable<List<String>> observeConversationsFor(User user);

}
