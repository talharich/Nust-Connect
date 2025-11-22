package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.PostVisibility;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts", indexes = {
        @Index(name = "idx_user_created", columnList = "user_id, created_at"),
        @Index(name = "idx_visibility", columnList = "visibility")
})
@SQLDelete(sql = "UPDATE posts SET deleted_at = NOW() WHERE post_id = ?")
@Where(clause = "deleted_at IS NULL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Post content cannot be empty")
    @Size(max = 5000, message = "Post content too long")
    @Column(name = "content_text", columnDefinition = "TEXT")
    private String contentText;

    @Size(max = 500, message = "Media URL too long")
    @Column(name = "media_url", length = 500)
    private String mediaUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private PostVisibility visibility = PostVisibility.PUBLIC;

    @Column(name = "like_count")
    @Builder.Default
    private Integer likeCount = 0;

    @Column(name = "comment_count")
    @Builder.Default
    private Integer commentCount = 0;

    @Column(name = "is_edited")
    @Builder.Default
    private Boolean isEdited = false;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Like> likes = new ArrayList<>();

    // Helper methods
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
        this.commentCount = comments.size();
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
        this.commentCount = comments.size();
    }

    public void addLike(Like like) {
        likes.add(like);
        like.setPost(this);
        this.likeCount = likes.size();
    }

    public void removeLike(Like like) {
        likes.remove(like);
        like.setPost(null);
        this.likeCount = likes.size();
    }

    public void markAsEdited() {
        this.isEdited = true;
    }
}