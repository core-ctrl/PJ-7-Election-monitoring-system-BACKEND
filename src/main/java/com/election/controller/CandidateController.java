package com.election.controller;

import com.election.model.Candidate;
import com.election.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateRepository candidateRepo;

    @GetMapping
    public List<Candidate> getAll() {
        return candidateRepo.findAll();
    }

    @GetMapping("/{id}")
    public Candidate getById(@PathVariable Long id) {
        return candidateRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Candidate create(@RequestBody Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @PutMapping("/{id}")
    public Candidate update(@PathVariable Long id, @RequestBody Candidate updated) {
        Candidate c = candidateRepo.findById(id).orElseThrow();
        c.setName(updated.getName());
        c.setParty(updated.getParty());
        return candidateRepo.save(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        candidateRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}