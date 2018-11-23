package com.springboot.jpa.spring.controller;

import com.springboot.jpa.spring.dto.PostDto;
import com.springboot.jpa.spring.dto.UserDto;
import com.springboot.jpa.spring.service.PostService;
import com.springboot.jpa.spring.service.RoleService;
import com.springboot.jpa.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private RoleService roleService;

    //Get All Users
    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    //Get User by user id
    @GetMapping(value = "/users/{id}")
    public UserDto getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    //Get all user with profile according to the user id
    @GetMapping(value = "/users/{id}/profile")
    public List<Object> getProfileByUserId(@PathVariable Integer id){
        return userService.getProfileByUserId(id);
    }

    //Get All Users with profile
    @GetMapping(value = "/users/profiles")
    public List<Object> getAllUsersWithProfile(){
        return userService.getAllUsersWithProfile();
    }

    //Save User
    @PostMapping(value = "/users")
    public String addUser(@RequestBody UserDto userDto){
        String status = userService.userSaveOrUpdate(userDto);
        return status;
    }

    //Update User
    @PutMapping(value = "/users")
    public String updateUser(@RequestBody UserDto userDto){
        String status = userService.userSaveOrUpdate(userDto);
        return status;
    }

    //Delete User
    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable Integer id){
        String status = userService.deleteUser(id);
        return status;
    }

    /************************************************************************
    *                                  Post
    * ***********************************************************************/

    //Get all post
    @GetMapping(value = "/users/{id}/posts")
    public PostDto getAllPost(){
        return postService.getAllPost();
    }

    /************************************************************************
     *                                  Role
     * ***********************************************************************/

    //Get role by user id
    @GetMapping(value = "/users/{id}/roles")
    public HashMap getRoleByUserId(@PathVariable Integer id){
        return roleService.getRoleByUserId(id);
    }
}
