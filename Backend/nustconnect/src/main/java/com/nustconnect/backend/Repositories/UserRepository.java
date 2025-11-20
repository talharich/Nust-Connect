package com.nustconnect.backend.Repositories;

import com.nustconnect.backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Example: find users by email
    User findByEmail(String email);
}
