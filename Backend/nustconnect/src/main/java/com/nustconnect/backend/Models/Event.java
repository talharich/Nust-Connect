package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.EventApprovalStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name="venue_id")
    private Venue venue;

    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    @Enumerated(EnumType.STRING)
    private EventApprovalStatus approvalStatus;

    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private List<EventRegistration> registrations;

    @PrePersist
    protected void onCreate() {
        if (approvalStatus == null) approvalStatus = EventApprovalStatus.PENDING;
    }

    // getters and setters
}
