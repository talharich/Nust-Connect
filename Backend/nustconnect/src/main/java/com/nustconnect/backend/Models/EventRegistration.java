package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.EventRegistrationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_registration",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"event_id", "user_id"})
        },
        indexes = {
                @Index(name = "idx_event_status", columnList = "event_id, status"),
                @Index(name = "idx_user_date", columnList = "user_id, registration_date")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRegistration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private EventRegistrationStatus status = EventRegistrationStatus.REGISTERED;

    @Column(name = "attended")
    @Builder.Default
    private Boolean attended = false;

    @Size(max = 500)
    @Column(name = "cancellation_reason", length = 500)
    private String cancellationReason;

    @PrePersist
    protected void onCreate() {
        if (status == null) {
            status = EventRegistrationStatus.REGISTERED;
        }
    }

    // Helper methods
    public void cancel(String reason) {
        this.status = EventRegistrationStatus.CANCELED;
        this.cancellationReason = reason;
    }

    public void waitlist() {
        this.status = EventRegistrationStatus.WAITLISTED;
    }

    public void register() {
        this.status = EventRegistrationStatus.REGISTERED;
    }

    public void markAttended() {
        this.attended = true;
    }
}