package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.MarketplaceOrderStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="marketplace_order")
public class MarketplaceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MarketplaceItem item;

    @ManyToOne
    private User buyer;

    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    private MarketplaceOrderStatus status;

    @PrePersist
    protected void onCreate() {
        orderTime = LocalDateTime.now();
        if (status == null) status = MarketplaceOrderStatus.PENDING;
    }

    // getters and setters
}