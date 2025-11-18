package com.nustconnect.backend.Models;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String contentText;
    private String mediaUrl;
    private String visibility; // public / friends / private
    private LocalDateTime createdAt;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    private List<Like> likes;
}

