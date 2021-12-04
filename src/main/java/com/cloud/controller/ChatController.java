package com.cloud.controller;

import com.cloud.service.ChatService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://34.127.76.90:3000",
        "http://localhost:3001", "http://34.127.76.90:3001",
        "http://localhost:3002", "http://34.127.76.90:3002"})
@RequestMapping("/chats")
public class ChatController {

    private static final Logger logger = Logger.getLogger(DropdownOptionController.class.getName());

    @Autowired
    private ChatService chatService;

    @GetMapping(value = "/userId/{userId}")
    public ResponseEntity<JSONObject> getRoleDropdown(@PathVariable Long userId){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info("senderId = " + userId);
        return chatService.getChatsBySenderId(userId);
    }
}
