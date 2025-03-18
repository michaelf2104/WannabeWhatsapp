package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.Message;
import com.wannabeWhatsapp.demo.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesBetweenUsers(Long senderId, Long receiverId) {
        return messageRepository.findAll();
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
