package com.springboot.jpa.spring.service;

import com.springboot.jpa.spring.converter.UserProfileConverter;
import com.springboot.jpa.spring.dto.UserProfileDto;
import com.springboot.jpa.spring.entity.UserProfile;
import com.springboot.jpa.spring.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileConverter userProfileConverter;

    @Transactional
    public List<UserProfileDto> getAllProfiles() {
        return userProfileRepository.findAll().stream().map(userProfileConverter::entityToDto).collect(Collectors.toList());
    }

    @Transactional
    public UserProfileDto getProfile(Integer id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElse(new UserProfile());
        return userProfileConverter.entityToDto(userProfile);
    }
}
