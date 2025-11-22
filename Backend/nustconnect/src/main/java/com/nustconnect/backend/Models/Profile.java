package com.nustconnect.backend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Size(max = 500, message = "Bio too long")
    @Column(length = 500)
    private String bio;

    @Size(max = 500)
    @Column(name = "profile_picture", length = 500)
    private String profilePicture;

    @Size(max = 500)
    @Column(name = "cover_photo", length = 500)
    private String coverPhoto;

    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Min(value = 1, message = "Year of study must be at least 1")
    @Max(value = 8, message = "Year of study cannot exceed 8")
    @Column(name = "year_of_study")
    private Integer yearOfStudy;

    @Pattern(regexp = "^[0-9+\\-()\\s]*$", message = "Invalid phone number format")
    @Size(max = 20)
    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @Size(max = 100)
    @Column(name = "major", length = 100)
    private String major;

    @Size(max = 200)
    @Column(name = "interests", length = 200)
    private String interests;
}