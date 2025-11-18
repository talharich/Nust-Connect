package com.nustconnect.backend.Models;

@Entity
@Table(name="friendship")
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
    private String status; // accepted / pending
}

