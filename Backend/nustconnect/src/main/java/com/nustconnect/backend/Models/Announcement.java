package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "announcement", indexes = {
        @Index(name = "idx_created_date", columnList = "created_at"),  // ← FIXED from posted_at
        @Index(name = "idx_priority", columnList = "priority")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Announcement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    @NotBlank(message = "Title is required")
    @Size(max = 300)
    @Column(nullable = false, length = 300)
    private String title;

    @NotBlank(message = "Content is required")
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posted_by", nullable = false)
    private User postedBy;

    @Column(name = "priority", length = 20)
    @Builder.Default
    private String priority = "NORMAL"; // HIGH, NORMAL, LOW

    @Column(name = "category", length = 50)
    private String category; // ACADEMIC, ADMINISTRATIVE, EVENT, GENERAL

    @Size(max = 100)
    @Column(length = 100)
    private String department;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "is_pinned")
    @Builder.Default
    private Boolean isPinned = false;

    @Column(name = "view_count")
    @Builder.Default
    private Integer viewCount = 0;

    @Size(max = 500)
    @Column(name = "attachment_url", length = 500)
    private String attachmentUrl;

    public void incrementViewCount() {
        this.viewCount++;
    }

    public boolean isExpired() {
        return expiryDate != null && LocalDateTime.now().isAfter(expiryDate);
    }
}