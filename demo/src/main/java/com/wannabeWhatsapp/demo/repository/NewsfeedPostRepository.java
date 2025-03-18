package com.wannabeWhatsapp.demo.repository;

import com.wannabeWhatsapp.demo.model.NewsfeedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsfeedPostRepository extends JpaRepository<NewsfeedPost, Long> {
}
