package com.nustconnect.backend.Models;

@Entity
@Table(name="events")
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name="venue_id")
    private Venue venue;

    private String title;
    private String description;
    private LocalDateTime eventDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    private String approvalStatus; // approved / pending / rejected

    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private List<EventRegistration> registrations;
}

