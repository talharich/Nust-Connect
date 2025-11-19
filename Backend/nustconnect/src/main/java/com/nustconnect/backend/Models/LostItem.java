package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="lost_items")
public class LostItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private String locationLost;
    private LocalDateTime dateLost;

    @ManyToOne
    @JoinColumn(name="reported_by", nullable=false)
    private User reportedBy;

    @PrePersist
    protected void onCreate() {
        if (dateLost == null) dateLost = LocalDateTime.now();
    }

    // getters and setters
}