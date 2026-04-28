// src/main/java/com/election/service/ElectionService.java
package com.election.service;

import com.election.model.Election;
import com.election.repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionService {

    private final ElectionRepository electionRepo;

    public List<Election> getAll() {
        return electionRepo.findAll();
    }

    public Election getById(Long id) {
        return electionRepo.findById(id).orElseThrow();
    }

    public Election save(Election e) {
        return electionRepo.save(e);
    }

    public Election update(Long id, Election updated) {
        Election e = getById(id);
        e.setTitle(updated.getTitle());
        e.setStatus(updated.getStatus());
        e.setVotesCast(updated.getVotesCast());
        return electionRepo.save(e);
    }

    public void delete(Long id) {
        electionRepo.deleteById(id);
    }
}