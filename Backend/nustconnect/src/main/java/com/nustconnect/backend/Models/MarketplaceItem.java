package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.MarketplaceCondition;
import com.nustconnect.backend.Enums.MarketplaceItemStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marketplace_item", indexes = {
        @Index(name = "idx_category_status", columnList = "category_id, status"),
        @Index(name = "idx_seller_created", columnList = "seller_id, created_at"),  // ← CHANGED from posted_at
        @Index(name = "idx_status", columnList = "status")
})
@SQLDelete(sql = "UPDATE marketplace_item SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketplaceItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 2000, message = "Description too long")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Condition is required")  // ← ADDED
    @Enumerated(EnumType.STRING)
    @Column(name = "condition_status", nullable = false, length = 20)
    private MarketplaceCondition conditionStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private MarketplaceItemStatus status = MarketplaceItemStatus.AVAILABLE;

    // ← REMOVED postedAt - use createdAt from BaseEntity instead

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private MarketplaceCategory category;

    @ElementCollection
    @CollectionTable(name = "marketplace_item_images",
            joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "image_url", length = 500)
    @Builder.Default
    private List<String> imageUrls = new ArrayList<>();

    @Size(max = 200)
    @Column(name = "location", length = 200)
    private String location;

    @Column(name = "view_count")
    @Builder.Default
    private Integer viewCount = 0;

    @Column(name = "is_negotiable")
    @Builder.Default
    private Boolean isNegotiable = false;

    // Helper methods
    public void incrementViewCount() {
        this.viewCount++;
    }

    public void markAsSold() {
        this.status = MarketplaceItemStatus.SOLD;
    }

    public void markAsReserved() {
        this.status = MarketplaceItemStatus.RESERVED;
    }

    public void markAsAvailable() {
        this.status = MarketplaceItemStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return this.status == MarketplaceItemStatus.AVAILABLE && !isDeleted();
    }
}