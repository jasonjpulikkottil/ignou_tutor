package com.jdots.ignou.user.view;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.jdots.ignou.user.data_model.User;

/**
 * Created for chatting on 19/08/16.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final UserView userView;

    public UserViewHolder(UserView itemView) {
        super(itemView);
        this.userView = itemView;
    }

    public void bind(final User user, final UserSelectionListener listener) {
        userView.display(user);
        userView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserSelected(user);
            }
        });
    }

    public interface UserSelectionListener {
        void onUserSelected(User user);
    }

}