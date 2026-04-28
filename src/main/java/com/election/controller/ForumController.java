// src/main/java/com/election/controller/ForumController.java
package com.election.controller;

import com.election.model.ForumPost;
import com.election.repository.ForumPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forum")
@RequiredArgsConstructor
public class ForumController {

    private final ForumPostRepository forumRepo;

    @GetMapping
    public List<ForumPost> getAll() {
        return forumRepo.findAll();
    }

    @PostMapping
    public ForumPost create(@RequestBody ForumPost post) {
        return forumRepo.save(post);
    }

    @PutMapping("/{id}/like")
    public ForumPost like(@PathVariable Long id) {
        ForumPost p = forumRepo.findById(id).orElseThrow();
        p.setLikes(p.getLikes() + 1);
        return forumRepo.save(p);
    }
}