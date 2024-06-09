package com.example.demo.dto;

import lombok.Data;

@Data
public class ChatMessage {
    //메시지 타임 : 입장(ENTER) , 채팅(TALK)
    public enum MessageType{
        ENTER,TALK,JOIN
    }
    private MessageType type; //메시지 타입
    private String roomId;    //방번호
    private String sender;    //보내는이
    private String message;   //메시지 내용
}
