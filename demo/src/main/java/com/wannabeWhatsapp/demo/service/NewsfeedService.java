package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.NewsfeedPost;
import com.wannabeWhatsapp.demo.repository.NewsfeedPostRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NewsfeedService {
    private final NewsfeedPostRepository newsfeedPostRepository;

    public NewsfeedService(NewsfeedPostRepository newsfeedPostRepository) {
        this.newsfeedPostRepository = newsfeedPostRepository;
    }

    public List<NewsfeedPost> getAllNewsfeedPosts() {
        return newsfeedPostRepository.findAll();
    }

    public NewsfeedPost createPost(NewsfeedPost post) {
        return newsfeedPostRepository.save(post);
    }

    public void deletePost(Long id) {
        newsfeedPostRepository.deleteById(id);
    }
}
