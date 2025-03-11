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
    public List<Message> getMessages(@PathVariable String user1, @PathVariable String user2) {
        return messageService.getMessagesBetweenUsers(user1, user2);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

}
