package com.cloud.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long senderId;

    @Column
    private Long receiverId;

    @Column
    private String message;

    @Column
    private Timestamp messageTimestamp;

}
