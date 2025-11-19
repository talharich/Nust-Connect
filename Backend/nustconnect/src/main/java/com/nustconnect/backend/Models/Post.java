package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.PostVisibility;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String contentText;
    private String mediaUrl;

    @Enumerated(EnumType.STRING)
    private PostVisibility visibility;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    private List<Like> likes;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters and setters
}