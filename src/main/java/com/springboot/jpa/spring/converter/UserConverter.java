package com.springboot.jpa.spring.converter;

import com.springboot.jpa.spring.dto.UserDto;
import com.springboot.jpa.spring.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto){

        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setPostsById(userDto.getPostDtos().stream().map(PostConverter::dtoToEntity).collect(Collectors.toList()));
        return user;

    }

    public UserDto entityToDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());

        //One to Many
        userDto.setPostDtos(user.getPostsById().stream().map(PostConverter::entityToDto).collect(Collectors.toList()));

        //Many to Many
//        userDto.setRoleUserDtos(user.getRoleUsersById().stream().map(RoleConverter::entityToDto).collect(Collectors.toList()));
        return userDto;
    }
}
