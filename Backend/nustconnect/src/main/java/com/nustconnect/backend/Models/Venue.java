package com.nustconnect.backend.Models;

import com.nustconnect.backend.Enums.VenueAvailability;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "venues", indexes = {
        @Index(name = "idx_availability", columnList = "availability_status")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @NotBlank(message = "Venue name is required")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
    @Column(nullable = false, length = 150)
    private String name;

    @NotBlank(message = "Location is required")
    @Size(max = 300, message = "Location description too long")
    @Column(nullable = false, length = 300)
    private String location;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_status", nullable = false, length = 30)
    @Builder.Default
    private VenueAvailability availabilityStatus = VenueAvailability.AVAILABLE;

    @Size(max = 1000)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Size(max = 500)
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "has_projector")
    @Builder.Default
    private Boolean hasProjector = false;

    @Column(name = "has_audio_system")
    @Builder.Default
    private Boolean hasAudioSystem = false;

    @Column(name = "has_whiteboard")
    @Builder.Default
    private Boolean hasWhiteboard = false;

    // Helper methods
    public boolean isAvailableForBooking() {
        return availabilityStatus == VenueAvailability.AVAILABLE;
    }
}