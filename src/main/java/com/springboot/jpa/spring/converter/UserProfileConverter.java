package com.springboot.jpa.spring.converter;
import com.springboot.jpa.spring.dto.UserProfileDto;
import com.springboot.jpa.spring.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserProfileConverter {

    @Autowired
    UserConverter userConverter;

    public UserProfile dtoToEntity(UserProfileDto userProfileDtoDto){

        UserProfile userProfile = new UserProfile();
        userProfile.setId(userProfileDtoDto.getId());
        userProfile.setAddress1(userProfileDtoDto.getAddress1());
        userProfile.setAddress2(userProfileDtoDto.getAddress2());
        userProfile.setCity(userProfileDtoDto.getCity());
        userProfile.setCountry(userProfileDtoDto.getCountry());
        userProfile.setGender(userProfileDtoDto.getGender());
        userProfile.setMobileNo(userProfileDtoDto.getMobileNo());
        userProfile.setDob(userProfileDtoDto.getDob());
        userProfile.setUserId(userProfileDtoDto.getUserId());

        return userProfile;
    }

    public UserProfileDto entityToDto(UserProfile userProfile){

        UserProfileDto userProfileDto = new UserProfileDto();

        userProfileDto.setId(userProfile.getId());
        userProfileDto.setAddress1(userProfile.getAddress1());
        userProfileDto.setAddress2(userProfile.getAddress2());
        userProfileDto.setCity(userProfile.getCity());
        userProfileDto.setCountry(userProfile.getCountry());
        userProfileDto.setGender(userProfile.getGender());
        userProfileDto.setMobileNo(userProfile.getMobileNo());
        userProfileDto.setDob(userProfile.getDob());
        userProfileDto.setUserId(userProfile.getUserId());

        userProfileDto.setUserDto(userConverter.entityToDto(userProfile.getUserByUserId()));

        return userProfileDto;
    }

}
