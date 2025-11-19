package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="found_items")
public class FoundItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private String locationFound;
    private LocalDateTime dateFound;

    @ManyToOne
    @JoinColumn(name="found_by", nullable=false)
    private User foundBy;

    @PrePersist
    protected void onCreate() {
        if (dateFound == null) dateFound = LocalDateTime.now();
    }

    // getters and setters
}