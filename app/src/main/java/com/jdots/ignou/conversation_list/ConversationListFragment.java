package com.jdots.ignou.conversation_list;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jdots.ignou.Dependencies;
import com.jdots.ignou.R;
import com.jdots.ignou.conversation_list.presenter.ConversationListPresenter;
import com.jdots.ignou.conversation_list.view.ConversationListDisplayer;
import com.jdots.ignou.navigation.AndroidConversationsNavigator;
import com.jdots.ignou.navigation.AndroidNavigator;

/**
 * Created for chatting on 29/07/16.
 */

public class ConversationListFragment extends Fragment {

    private ConversationListPresenter presenter;
    private AndroidConversationsNavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conversations, container, false);
        getActivity().setTitle(R.string.conversations_toolbar_title);

        navigator = new AndroidConversationsNavigator((AppCompatActivity)getActivity(),new AndroidNavigator(getActivity()));
        presenter = new ConversationListPresenter(
                (ConversationListDisplayer) rootView.findViewById(R.id.conversationsView),
                Dependencies.INSTANCE.getConversationListService(),
                navigator,
                Dependencies.INSTANCE.getLoginService(),
                Dependencies.INSTANCE.getUserService()
                );

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
