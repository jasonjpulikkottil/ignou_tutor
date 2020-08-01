package com.jdots.ignou.conversation.view;

import androidx.recyclerview.widget.RecyclerView;

import com.jdots.ignou.conversation.data_model.Message;

/**
 * Created for chatting on 29/07/16.
 */

class ConversationMessageViewHolder extends RecyclerView.ViewHolder {

    private final ConversationMessageView conversationMessageView;

    public ConversationMessageViewHolder(ConversationMessageView messageView) {
        super(messageView);
        this.conversationMessageView = messageView;
    }

    public void bind(Message message) {
        conversationMessageView.display(message);
    }
}
