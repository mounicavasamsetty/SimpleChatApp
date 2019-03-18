package com.trautmann.simplechatapp.rest;

import android.support.annotation.Nullable;

import com.trautmann.simplechatapp.rest.response.CreateChat;
import com.trautmann.simplechatapp.rest.response.CreateChatMessage;
import com.trautmann.simplechatapp.rest.response.CreateUser;
import com.trautmann.simplechatapp.rest.response.GenericResponse;
import com.trautmann.simplechatapp.rest.response.GetChatMessagesList;
import com.trautmann.simplechatapp.rest.response.GetChatsList;
import com.trautmann.simplechatapp.rest.response.GetCurrentUser;
import com.trautmann.simplechatapp.rest.response.UpdateChat;
import com.trautmann.simplechatapp.rest.response.UpdateUser;
import com.trautmann.simplechatapp.rest.service.AuthService;
import com.trautmann.simplechatapp.rest.service.ChatsService;
import com.trautmann.simplechatapp.rest.service.UserService;

import io.reactivex.Single;

/**
 * Created by Brandon Trautmann
 */

public class RestActions {

    // Auth
    public static Single<GenericResponse> login(String email, String password) {
        RestAction<GenericResponse> action = new RestAction<>(
                ServiceCreator.createService(AuthService.class).login(email, password));
        return action.perform();
    }

    public static Single<GenericResponse> logout() {
        RestAction<GenericResponse> action = new RestAction<>(
                ServiceCreator.createService(AuthService.class).logout());
        return action.perform();
    }

    // User
    public static Single<GetCurrentUser> getCurrentUser() {
        RestAction<GetCurrentUser> action = new RestAction<>(
                ServiceCreator.createService(UserService.class).getCurrentUser());
        return action.perform();
    }

    public static Single<UpdateUser> updateUser(@Nullable String name, @Nullable String email) {
        RestAction<UpdateUser> action = new RestAction<>(
                ServiceCreator.createService(UserService.class).updateUser(name, email));
        return action.perform();
    }

    public static Single<CreateUser> createUser(String name, String email, String password,
                                                String passwordConfirmation) {
        RestAction<CreateUser> action = new RestAction<>(
                ServiceCreator.createService(UserService.class).createUser(name, email, password,
                        passwordConfirmation));
        return action.perform();
    }

    // Chats
    public static Single<GetChatsList> getChatsList() {
        RestAction<GetChatsList> action = new RestAction<>(
                ServiceCreator.createService(ChatsService.class).getChatsList());
        return action.perform();
    }

    public static Single<GetChatMessagesList> getChatMessagesList(int chatId) {
        RestAction<GetChatMessagesList> action = new RestAction<>(
                ServiceCreator.createService(ChatsService.class).getChatMessagesList(chatId));
        return action.perform();
    }

    public static Single<CreateChatMessage> createChatMessage(int chatId, String message) {
        RestAction<CreateChatMessage> action = new RestAction<>(
                ServiceCreator.createService(ChatsService.class).createChatMessage(chatId, message));
        return action.perform();
    }


    public static Single<CreateChat> createChat(String chatName, String firstChatMessage) {
        RestAction<CreateChat> action = new RestAction<>(
                ServiceCreator.createService(ChatsService.class).createChat(chatName, firstChatMessage));
        return action.perform();
    }

    public static Single<UpdateChat> updateChat(int chatId, String newChatName) {
        RestAction<UpdateChat> action = new RestAction<>(
                ServiceCreator.createService(ChatsService.class).updateChat(chatId, newChatName));
        return action.perform();
    }
}
