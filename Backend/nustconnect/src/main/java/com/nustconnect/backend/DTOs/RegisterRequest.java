package com.nustconnect.backend.DTOs;

import com.nustconnect.backend.Enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String studentId;
    private String department;
    private String phoneNumber;
    private UserRole role;
}