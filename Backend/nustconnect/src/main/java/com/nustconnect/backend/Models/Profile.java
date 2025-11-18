package com.nustconnect.backend.Models;

@Entity
@Table(name="profiles")
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String bio;
    private String profilePicture;
    private String coverPhoto;
    private LocalDateTime dateOfBirth;
    private Integer yearOfStudy;
    private String contactNo;

    // getters and setters
}

