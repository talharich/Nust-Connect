package com.nustconnect.backend.Models;

@Entity
@Table(name="notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String type; // post_like / comment / event / system
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}

