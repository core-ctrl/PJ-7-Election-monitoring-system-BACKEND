// src/main/java/com/election/model/Candidate.java
package com.election.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String party;
    private String symbol;
    private int votes;
    private String color;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;
}