package com.nustconnect.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nustconnect.backend.Enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_department", columnList = "department")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // Add these fields to User.java
    @Column(name = "student_id", unique = true)
    private String studentId; // NUST student ID

    @Column(name = "phone_number", length = 20)
    private String phoneNumber; // For ride-sharing contact

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @NotBlank(message = "Password is required")
    @JsonIgnore
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private UserRole role = UserRole.STUDENT;

    @Size(max = 100, message = "Department name too long")
    @Column(length = 100)
    private String department;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "is_email_verified")
    @Builder.Default
    private Boolean isEmailVerified = false;

    @Column(name = "verification_token")
    @JsonIgnore
    private String verificationToken;

    // Relationships
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<Event> createdEvents = new ArrayList<>();

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<Club> createdClubs = new ArrayList<>();

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Friendship> following = new ArrayList<>();

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Friendship> followers = new ArrayList<>();

    // Helper methods for bidirectional relationships
//    public void addPost(Post post) {
//        posts.add(post);
//        post.setUser(this);
//    }
//
//    public void removePost(Post post) {
//        posts.remove(post);
//        post.setUser(null);
//    }
//
//    public void addComment(Comment comment) {
//        comments.add(comment);
//        comment.setUser(this);
//    }
//
//    public void addLike(Like like) {
//        likes.add(like);
//        like.setUser(this);
//    }
//
//    public void removeLike(Like like) {
//        likes.remove(like);
//        like.setUser(null);
//    }
}