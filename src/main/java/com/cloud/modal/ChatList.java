package com.cloud.modal;

import java.util.List;

public class ChatList {

    private long receiverId;
    private String firstName;
    private String lastName;
    private List<ChatMessage> chatMessages;

    public ChatList(long receiverId, String firstName, String lastName) {
        this.receiverId = receiverId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ChatList() {
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }
}
