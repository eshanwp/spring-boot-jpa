package com.springboot.jpa.spring.service;

import com.springboot.jpa.spring.converter.UserConverter;
import com.springboot.jpa.spring.dto.UserDto;
import com.springboot.jpa.spring.entity.User;
import com.springboot.jpa.spring.repository.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserConverter userConverter;

    // Define the log object for this class
    private final Logger log = Logger.getLogger(this.getClass());

    //Get all users
    @Transactional
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::entityToDto).collect(Collectors.toList());
//        return userRepository.findAll();
    }

    //Get user by user id
    @Transactional
    public UserDto getUser(Integer id) {
        User user =  userRepository.findById(id).orElse(new User());

        if (user.getUserName()==null){
            log.info("User not found");
        }else{
            log.info("User found " + user.getUserName());
        }
        return userConverter.entityToDto(user);
    }

    //Save or update user
    @Transactional
    public String userSaveOrUpdate(UserDto userDto) {

        User user = userConverter.dtoToEntity(userDto);

        //Check the user exist or not
        UserDto userResult =  getUser(user.getId());

        userRepository.save(user);

        if (userResult.getId()==0){
            log.info("User has been successfully inserted");
            return "User has been successfully inserted";
        }else if (userResult.getId()!=0){
            log.info("User has been successfully updated");
            return "User has been successfully updated";
        }else{
            log.info("User has not been inserted");
            return "User has not been inserted";
        }
    }

    @Transactional
    public String deleteUser(Integer id) {

        //Check the user exist or not
        UserDto userResult =  getUser(id);

        if (userResult.getId()!=0){
            userRepository.deleteById(id);
            log.info("User has been successfully deleted");
            return "User has been successfully deleted";
        }else{
            log.info("User not found");
            return "User not found";
        }

    }


    @Transactional
    public List<Object> getProfileByUserId(Integer id) {
        return userRepository.getProfileByUserId(id);
    }

    @Transactional
    public List<Object> getAllUsersWithProfile() {
        return userRepository.findByUserProfile();
    }


}
