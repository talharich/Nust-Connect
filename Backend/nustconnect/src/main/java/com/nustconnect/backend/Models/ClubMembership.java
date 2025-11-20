package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "club_membership",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"club_id", "user_id"})
        },
        indexes = {
                @Index(name = "idx_club_status", columnList = "club_id, status")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubMembership extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "member_role", length = 50)
    @Builder.Default
    private String memberRole = "MEMBER"; // PRESIDENT, VICE_PRESIDENT, MEMBER

    @Column(name = "status", length = 20)
    @Builder.Default
    private String status = "ACTIVE"; // ACTIVE, INACTIVE

    public void makePresident() {
        this.memberRole = "PRESIDENT";
    }

    public void makeVicePresident() {
        this.memberRole = "VICE_PRESIDENT";
    }
}
