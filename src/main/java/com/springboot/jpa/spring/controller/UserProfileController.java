package com.springboot.jpa.spring.controller;

import com.springboot.jpa.spring.dto.UserProfileDto;
import com.springboot.jpa.spring.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    //Get all profiles details
    @GetMapping("/profiles")
    public List<UserProfileDto> getAllProfiles(){
        return userProfileService.getAllProfiles();
    }

    //Get all profile details by
    @GetMapping(value = "/profiles/{id}")
    public UserProfileDto getProfile(@PathVariable Integer id){
        return userProfileService.getProfile(id);
    }
}
