package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.FriendshipStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="friendship", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"follower_id", "following_id"})
})
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name="following_id")
    private User following;

    private LocalDateTime sinceDate;

    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;

    @PrePersist
    protected void onCreate() {
        if (status == null) status = FriendshipStatus.PENDING;
        sinceDate = LocalDateTime.now();
    }

    // getters and setters
}
