package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

// ============== Report.java ==============
@Entity
@Table(name = "reports", indexes = {
        @Index(name = "idx_target", columnList = "target_type, target_id"),
        @Index(name = "idx_status", columnList = "status")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Report reason is required")
    @Size(max = 1000, message = "Reason too long")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false, length = 20)
    private ReportTargetType targetType;

    @NotNull(message = "Target ID is required")
    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_by", nullable = false)
    private User reportedBy;

    @Column(length = 20)
    @Builder.Default
    private String status = "PENDING"; // PENDING, REVIEWED, RESOLVED, DISMISSED

    @Size(max = 500)
    @Column(name = "admin_notes", length = 500)
    private String adminNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewed_by")
    private User reviewedBy;

    // Helper methods
    public void resolve(User admin, String notes) {
        this.status = "RESOLVED";
        this.reviewedBy = admin;
        this.adminNotes = notes;
    }

    public void dismiss(User admin, String notes) {
        this.status = "DISMISSED";
        this.reviewedBy = admin;
        this.adminNotes = notes;
    }
}