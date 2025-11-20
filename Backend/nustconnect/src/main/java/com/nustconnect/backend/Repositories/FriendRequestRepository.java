package com.nustconnect.backend.Repositories;

import com.nustconnect.backend.Enums.FriendshipStatus;
import com.nustconnect.backend.Models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<Friendship, Long> {

    // Get all friend requests sent *to* a user
    List<Friendship> findByFollowingUserId(Long userId);

    // Get all friend requests sent *by* a user
    List<Friendship> findByFollowerUserId(Long userId);

    // If we want pending requests only
    List<Friendship> findByFollowingUserIdAndStatus(Long userId, FriendshipStatus status);

    List<Friendship> findByFollowerUserIdAndStatus(Long userId, FriendshipStatus status);
}

