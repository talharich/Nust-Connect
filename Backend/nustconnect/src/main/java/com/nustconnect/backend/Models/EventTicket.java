package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_ticket", indexes = {
        @Index(name = "idx_event_user", columnList = "event_id, user_id"),
        @Index(name = "idx_qr_code", columnList = "qr_code")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventTicket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "qr_code", unique = true, length = 500)
    private String qrCode;

    @Column(name = "ticket_number", unique = true, length = 50)
    private String ticketNumber;

    @Column(name = "is_checked_in")
    @Builder.Default
    private Boolean isCheckedIn = false;

    @Column(name = "checked_in_at")
    private LocalDateTime checkedInAt;

    public void checkIn() {
        this.isCheckedIn = true;
        this.checkedInAt = LocalDateTime.now();
    }
}
