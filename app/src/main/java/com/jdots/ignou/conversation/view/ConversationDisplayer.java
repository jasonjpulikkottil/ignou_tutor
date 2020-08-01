package com.jdots.ignou.conversation.view;

import com.jdots.ignou.conversation.data_model.Chat;
import com.jdots.ignou.conversation.data_model.Message;

/**
 * Created for chatting on 29/07/16.
 */

public interface ConversationDisplayer {

    void displayOldMessages(Chat chat, String user);

    void display(Chat chat, String user);

    void addToDisplay(Message message, String user);

    void setupToolbar(String user, String image, long lastSeen);

    void showTyping();

    void hideTyping();

    void attach(ConversationActionListener conversationInteractionListener);

    void detach(ConversationActionListener conversationInteractionListener);

    void enableInteraction();

    void disableInteraction();

    interface ConversationActionListener {

        void onPullMessages();

        void onUpPressed();

        void onMessageLengthChanged(int messageLength);

        void onSubmitMessage(String message);

    }

}
