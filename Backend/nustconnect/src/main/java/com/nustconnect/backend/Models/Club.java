package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.ClubCategory;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    @Enumerated(EnumType.STRING)
    private ClubCategory category;

    @OneToMany(mappedBy = "club")
    private List<ClubMembership> members;

    @Column(name = "is_approved")
    private Boolean isApproved = false;

    @OneToMany(mappedBy="club", cascade=CascadeType.ALL)
    private List<Event> events;

    // getters and setters
}