package com.nustconnect.backend.Models;

@Entity
@Table(name="event_registration")
public class EventRegistration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime registrationDate;
    private String status; // registered / canceled / waitlisted
}

