// src/main/java/com/election/model/Region.java
package com.election.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int turnout;
    private int fraud;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;
}