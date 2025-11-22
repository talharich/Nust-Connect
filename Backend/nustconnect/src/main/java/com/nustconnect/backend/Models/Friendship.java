package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.FriendshipStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "friendship",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"follower_id", "following_id"})
        },
        indexes = {
                @Index(name = "idx_follower_status", columnList = "follower_id, status"),
                @Index(name = "idx_following_status", columnList = "following_id, status")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id", nullable = false)
    private User following;

    @Column(name = "since_date")
    private LocalDateTime sinceDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private FriendshipStatus status = FriendshipStatus.PENDING;

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = FriendshipStatus.PENDING;
        }
        sinceDate = LocalDateTime.now();
    }

    // Helper methods
    public void accept() {
        this.status = FriendshipStatus.ACCEPTED;
    }

    public boolean isAccepted() {
        return this.status == FriendshipStatus.ACCEPTED;
    }

    public boolean isPending() {
        return this.status == FriendshipStatus.PENDING;
    }
}