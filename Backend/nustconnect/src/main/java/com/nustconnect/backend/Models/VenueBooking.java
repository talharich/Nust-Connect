package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.VenueBookingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="venue_booking", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"venue_id", "startTime", "endTime"})
})
public class VenueBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name="venue_id", nullable=false)
    private Venue venue;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private VenueBookingStatus approvalStatus;

    @PrePersist
    protected void onCreate() {
        if (approvalStatus == null) approvalStatus = VenueBookingStatus.PENDING;
    }

    // getters and setters
}
