package com.example.demo.service;

import com.example.demo.dto.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisSubscriber implements MessageListener {
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messageTemplate;

    /**
     * Redis에서 메시지가 발행(publish)되면 대기하고 있던 onMessage가 해당 메시지를 받아 처리한다.
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try{
            //redis에서 발행된 데이터를 받아 deserialize
            String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());

            //chatMessage 객체로 매핑
            ChatMessage roomMessage = objectMapper.readValue(publishMessage,ChatMessage.class);

            //webSocket 구독자에게 채팅 메시지 send
            messageTemplate.convertAndSend("/sub/chat/room/" + roomMessage.getRoomId(), roomMessage);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
