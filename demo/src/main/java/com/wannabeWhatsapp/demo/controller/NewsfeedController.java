package com.wannabeWhatsapp.demo.controller;

import com.wannabeWhatsapp.demo.model.NewsfeedPost;
import com.wannabeWhatsapp.demo.service.NewsfeedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsfeed")
public class NewsfeedController {
    private final NewsfeedService newsfeedService;

    public NewsfeedController(NewsfeedService newsfeedService) {
        this.newsfeedService = newsfeedService;
    }

    @GetMapping
    public List<NewsfeedPost> getAllPosts() {
        return newsfeedService.getAllPosts();
    }

    @PostMapping
    public NewsfeedPost createPost(@RequestBody NewsfeedPost post) {
        return newsfeedService.createPost(post);
    }
}
