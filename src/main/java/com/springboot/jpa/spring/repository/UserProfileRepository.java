package com.springboot.jpa.spring.repository;

import com.springboot.jpa.spring.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
