package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.NewsfeedPost;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NewsfeedService {
    private final List<NewsfeedPost> posts = new ArrayList<>();

    public List<NewsfeedPost> getAllPosts() {
        return new ArrayList<>(posts);
    }

    public NewsfeedPost createPost(NewsfeedPost post) {
        posts.add(post);
        return post;
    }
}
