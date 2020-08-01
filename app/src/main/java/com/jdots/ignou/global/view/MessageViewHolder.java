package com.jdots.ignou.global.view;

import androidx.recyclerview.widget.RecyclerView;

import com.jdots.ignou.global.data_model.Message;
import com.jdots.ignou.user.data_model.User;

/**
 * Created for chatting on 08/08/16.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private final MessageView messageView;

    public MessageViewHolder(MessageView messageView) {
        super(messageView);
        this.messageView = messageView;
    }

    public void bind(User user, Message message) {
        messageView.display(user, message);
    }
}
