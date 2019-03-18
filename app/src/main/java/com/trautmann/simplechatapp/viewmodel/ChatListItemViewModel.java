package com.trautmann.simplechatapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.trautmann.simplechatapp.R;
import com.trautmann.simplechatapp.model.Chat;
import com.trautmann.simplechatapp.util.Constants;
import com.trautmann.simplechatapp.view.ChatDetailActivity;

/**
 * Created by Brandon Trautmann
 */

public class ChatListItemViewModel {

    private Context context;
    private Chat chat;

    public ChatListItemViewModel(Context context, Chat chat) {
        this.context = context;
        this.chat = chat;
    }

    public String getChatName() {
        return chat.getName();
    }

    public String getLastChatMessage() {
        return context.getString(R.string.chat_last_message,
                chat.getLastChatMessage().getSender().getName(),
                chat.getLastChatMessage().getMessage());
    }

    public View.OnClickListener onChatClicked() {
        return view -> {
            Intent intent = new Intent(context, ChatDetailActivity.class);
            intent.putExtra(Constants.IntentArguments.CHAT_ID, chat.getId());
            intent.putExtra(Constants.IntentArguments.CHAT_NAME, chat.getName());
            context.startActivity(intent);
        };
    }

}
