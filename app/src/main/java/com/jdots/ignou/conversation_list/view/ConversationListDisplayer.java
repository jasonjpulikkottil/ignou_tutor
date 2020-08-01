package com.jdots.ignou.conversation_list.view;

import com.jdots.ignou.conversation_list.data_model.Conversation;
import com.jdots.ignou.conversation_list.data_model.Conversations;

/**
 * Created for chatting on 29/07/16.
 */

public interface ConversationListDisplayer {

    void display(Conversations conversations);

    void addToDisplay(Conversation conversation);

    void attach(ConversationInteractionListener conversationInteractionListener);

    void detach(ConversationInteractionListener conversationInteractionListener);

    interface ConversationInteractionListener {

        void onConversationSelected(Conversation conversation);

    }

}
