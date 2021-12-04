package com.cloud.service;

import com.cloud.modal.ChatInfo;
import com.cloud.modal.ChatList;
import com.cloud.modal.ChatMessage;
import com.cloud.repository.ChatRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ChatService {

    private static final Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    private ChatRepository chatRepository;

    public ResponseEntity<JSONObject> getChatsBySenderId(Long userId){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            logger.info("Retrieving all chats for a sender from RDS");
//            List<ChatInfo> chatList = chatRepository.getChatBySenderId(userId);
            List<ChatList> chatList = chatRepository.getChatListBySenderId(userId);

            chatList.forEach(receiver -> {
                List<ChatMessage> chatMessageList = chatRepository.getChatMessageListByReceiverId(receiver.getReceiverId());
                receiver.setChatMessageList(chatMessageList);
            });

            JSONObject chats = new JSONObject();
            chats.put("chats", chatList);
            responseData.put("message","success");
            responseData.put("data", chats);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred getting chats for a senderId from RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }
}
