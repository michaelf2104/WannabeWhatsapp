package com.wannabeWhatsapp.demo.controller;

import com.wannabeWhatsapp.demo.model.Message;
import com.wannabeWhatsapp.demo.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{user1}/{user2}")
    public List<Message> getMessages(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return messageService.getMessagesBetweenUsers(senderId, receiverId);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

}
