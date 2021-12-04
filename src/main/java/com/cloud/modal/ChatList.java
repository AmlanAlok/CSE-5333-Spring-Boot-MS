package com.cloud.modal;

public class ChatList {

    private long receiverId;
    private String firstName;
    private String lastName;

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
}
