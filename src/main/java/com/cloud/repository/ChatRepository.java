package com.cloud.repository;

import com.cloud.entity.Chat;
import com.cloud.modal.ChatInfo;
import com.cloud.modal.ChatList;
import com.cloud.modal.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query("SELECT new com.cloud.modal.ChatInfo(c.id, c.senderId, c.receiverId, u.firstName as receiverFirstName, u.lastName as receiverLastName, c.message, c.messageTimestamp) " +
            "FROM Chat c " +
            "JOIN User u ON c.receiverId = u.id " +
            "WHERE c.senderId = :userId or c.receiverId = :userId " +
            "ORDER By c.id ")
    List<ChatInfo> getChatBySenderId(@Param("userId") Long userId);

    @Query("SELECT DISTINCT new com.cloud.modal.ChatList(c.receiverId, u.firstName, u.lastName) " +
            "FROM Chat c " +
            "JOIN User u ON c.receiverId = u.id " +
            "WHERE c.senderId = :userId " +
            "ORDER By c.receiverId ")
    List<ChatList> getChatListBySenderId(@Param("userId") Long userId);

    @Query("SELECT new com.cloud.modal.ChatMessage(c.id, c.senderId, c.receiverId, c.message, c.messageTimestamp) " +
            "FROM Chat c " +
            "JOIN User u ON c.receiverId = u.id " +
            "WHERE c.senderId = :userId or c.receiverId = :userId " +
            "ORDER By c.id ")
    List<ChatMessage> getChatMessageListByReceiverId(@Param("userId") Long userId);
}
