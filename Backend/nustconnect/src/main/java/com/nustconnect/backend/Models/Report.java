package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.ReportTargetType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @Enumerated(EnumType.STRING)
    private ReportTargetType targetType;

    private Long targetId;

    private LocalDateTime createdAt;

    @ManyToOne
    private User reportedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
