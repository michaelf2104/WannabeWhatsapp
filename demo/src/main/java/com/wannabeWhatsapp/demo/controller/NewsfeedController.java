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
    public List<NewsfeedPost> getAllNewsfeedPosts() {
        return newsfeedService.getAllNewsfeedPosts();
    }

    @PostMapping
    public NewsfeedPost createPost(@RequestBody NewsfeedPost post) {
        return newsfeedService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        newsfeedService.deletePost(id);
    }

}
