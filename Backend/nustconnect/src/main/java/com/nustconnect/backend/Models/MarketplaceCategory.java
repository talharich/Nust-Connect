package com.nustconnect.backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name="marketplace_category")
public class MarketplaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // getters and setters
}