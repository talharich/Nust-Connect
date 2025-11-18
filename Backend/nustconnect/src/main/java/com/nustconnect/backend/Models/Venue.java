package com.nustconnect.backend.Models;

@Entity
@Table(name="venues")
public class Venue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    private String name;
    private String location;
    private Integer capacity;
    private String availabilityStatus; // available / booked
}

