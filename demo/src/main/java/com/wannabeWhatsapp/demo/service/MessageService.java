package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final List<Message> messages = new ArrayList<>();

    public List<Message> getMessagesBetweenUsers(String user1, String user2) {
        List<Message> conversation = new ArrayList<>();
        for (Message message : messages) {
            if ((message.getSenderId().equals(user1) && message.getReceiverId().equals(user2)) ||
                    (message.getSenderId().equals(user2) && message.getReceiverId().equals(user1))) {
                conversation.add(message);
            }
        }
        return conversation;
    }

    public Message sendMessage(Message message) {
        messages.add(message);
        return message;
    }
}
