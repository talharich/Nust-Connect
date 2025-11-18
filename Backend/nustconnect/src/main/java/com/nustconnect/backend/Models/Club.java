package com.nustconnect.backend.Models;

@Entity
@Table(name="clubs")
public class Club {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    private String category; // academic / cultural / sports

    @OneToMany(mappedBy="club", cascade=CascadeType.ALL)
    private List<Event> events;
}

