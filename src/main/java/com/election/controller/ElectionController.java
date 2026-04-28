// src/main/java/com/election/controller/ElectionController.java
package com.election.controller;

import com.election.model.Election;
import com.election.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/elections")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionService electionService;

    @GetMapping
    public List<Election> getAll() {
        return electionService.getAll();
    }

    @GetMapping("/{id}")
    public Election getById(@PathVariable Long id) {
        return electionService.getById(id);
    }

    @PostMapping
    public Election create(@RequestBody Election election) {
        return electionService.save(election);
    }

    @PutMapping("/{id}")
    public Election update(@PathVariable Long id, @RequestBody Election election) {
        return electionService.update(id, election);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        electionService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}