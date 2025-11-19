package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.MarketplaceCondition;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="marketplace_item")
public class MarketplaceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;

    @Enumerated(EnumType.STRING)
    private MarketplaceCondition conditionStatus;

    private LocalDateTime postedAt;

    @ManyToOne
    private User seller;

    @ManyToOne
    private MarketplaceCategory category;

    @PrePersist
    protected void onCreate() {
        postedAt = LocalDateTime.now();
    }

    // getters and setters
}
