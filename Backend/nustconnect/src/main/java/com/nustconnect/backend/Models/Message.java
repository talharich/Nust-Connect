package com.nustconnect.backend.Models;

@Entity
@Table(name="messages")
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

    private String content;
    private LocalDateTime sentAt;
    private Boolean isRead;
}
