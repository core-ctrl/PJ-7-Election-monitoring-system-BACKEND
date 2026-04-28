package com.election.controller;

import com.election.model.Report;
import com.election.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportRepository reportRepo;

    @GetMapping
    public List<Report> getAll() {
        return reportRepo.findAll();
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) {
        return reportRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Report create(@RequestBody Report report) {
        return reportRepo.save(report);
    }

    @PutMapping("/{id}/status")
    public Report updateStatus(@PathVariable Long id, @RequestParam String status) {
        Report r = reportRepo.findById(id).orElseThrow();
        r.setStatus(status);
        return reportRepo.save(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reportRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}