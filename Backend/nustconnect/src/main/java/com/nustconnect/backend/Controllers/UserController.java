package com.nustconnect.backend.Controllers;

import com.nustconnect.backend.DTOs.User.*;
import com.nustconnect.backend.Models.Profile;
import com.nustconnect.backend.Models.User;
import com.nustconnect.backend.Services.ProfileService;
import com.nustconnect.backend.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;

    // ==================== GET USER BY ID ====================
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(mapToUserResponseDTO(user));
    }

    // ==================== GET ALL USERS ====================
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> response = users.stream()
                .map(this::mapToUserResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // ==================== SEARCH USERS ====================
    @GetMapping("/search")
    public ResponseEntity<List<UserSummaryDTO>> searchUsers(@RequestParam String keyword) {
        List<User> users = userService.searchUsers(keyword);
        List<UserSummaryDTO> response = users.stream()
                .map(this::mapToUserSummaryDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // ==================== UPDATE USER ====================
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateUserRequestDTO request) {
        User updatedUser = User.builder()
                .name(request.getName())
                .department(request.getDepartment())
                .phoneNumber(request.getPhoneNumber())
                .build();

        User user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(mapToUserResponseDTO(user));
    }

    // ==================== ACTIVATE/DEACTIVATE USER ====================
    @PatchMapping("/{userId}/activate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> activateUser(@PathVariable Long userId) {
        User user = userService.activateUser(userId);
        return ResponseEntity.ok(mapToUserResponseDTO(user));
    }

    @PatchMapping("/{userId}/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> deactivateUser(@PathVariable Long userId) {
        User user = userService.deactivateUser(userId);
        return ResponseEntity.ok(mapToUserResponseDTO(user));
    }

    // ==================== DELETE USER ====================
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    // ==================== PROFILE ENDPOINTS ====================
    @GetMapping("/{userId}/profile")
    public ResponseEntity<ProfileResponseDTO> getProfile(@PathVariable Long userId) {
        Profile profile = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(mapToProfileResponseDTO(profile));
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<ProfileResponseDTO> createProfile(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateProfileRequestDTO request) {
        Profile profile = mapToProfile(request);
        Profile createdProfile = profileService.createProfile(userId, profile);
        return ResponseEntity.ok(mapToProfileResponseDTO(createdProfile));
    }

    @PutMapping("/{userId}/profile")
    public ResponseEntity<ProfileResponseDTO> updateProfile(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateProfileRequestDTO request) {
        Profile profile = mapToProfile(request);
        Profile updatedProfile = profileService.updateProfile(userId, profile);
        return ResponseEntity.ok(mapToProfileResponseDTO(updatedProfile));
    }

    // ==================== MAPPER METHODS ====================
    private UserResponseDTO mapToUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .studentId(user.getStudentId())
                .department(user.getDepartment())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().name())
                .isActive(user.getIsActive())
                .isEmailVerified(user.getIsEmailVerified())
                .build();
    }

    private UserSummaryDTO mapToUserSummaryDTO(User user) {
        String profilePicture = null;
        try {
            Profile profile = profileService.getProfileByUserId(user.getUserId());
            profilePicture = profile.getProfilePicture();
        } catch (Exception e) {
            // Profile doesn't exist, use null
        }

        return UserSummaryDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .profilePicture(profilePicture)
                .department(user.getDepartment())
                .build();
    }

    private ProfileResponseDTO mapToProfileResponseDTO(Profile profile) {
        return ProfileResponseDTO.builder()
                .profileId(profile.getProfileId())
                .userId(profile.getUser().getUserId())
                .bio(profile.getBio())
                .profilePicture(profile.getProfilePicture())
                .coverPhoto(profile.getCoverPhoto())
                .dateOfBirth(profile.getDateOfBirth())
                .yearOfStudy(profile.getYearOfStudy())
                .contactNo(profile.getContactNo())
                .major(profile.getMajor())
                .interests(profile.getInterests())
                .build();
    }

    private Profile mapToProfile(UpdateProfileRequestDTO dto) {
        return Profile.builder()
                .bio(dto.getBio())
                .profilePicture(dto.getProfilePicture())
                .coverPhoto(dto.getCoverPhoto())
                .dateOfBirth(dto.getDateOfBirth())
                .yearOfStudy(dto.getYearOfStudy())
                .contactNo(dto.getContactNo())
                .major(dto.getMajor())
                .interests(dto.getInterests())
                .build();
    }
}