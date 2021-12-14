package com.cloud.modal;

import java.sql.Timestamp;
import java.util.Date;

public class ChatInfo {

    private long id;
    private long senderId;
    private long receiverId;
    private String receiverFirstName;
    private String receiverLastName;
    private String message;
    private Date messageTimestamp;

    public ChatInfo(long id, long senderId, long receiverId, String receiverFirstName, String receiverLastName, String message, Date messageTimestamp) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.message = message;
        this.messageTimestamp = messageTimestamp;
    }

    public ChatInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(Timestamp messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }
}
