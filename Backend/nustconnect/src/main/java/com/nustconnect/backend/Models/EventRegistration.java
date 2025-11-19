package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.EventRegistrationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="event_registration")
public class EventRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    private EventRegistrationStatus status;

    @PrePersist
    protected void onCreate() {
        if (status == null) status = EventRegistrationStatus.REGISTERED;
        registrationDate = LocalDateTime.now();
    }

    // getters and setters
}
