package com.springboot.jpa.spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class UserDto implements Serializable {

    private int id;
    private String email;
    private String userName;
    private String password;

    //One to One
    private UserProfileDto userProfileDto;

    //One to Many
    private Collection<PostDto> postDtos = new ArrayList<>();

    //Many to Many
    private Collection<RoleUserDto> roleUserDtos = new ArrayList<>();

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfileDto getUserProfileDto() {
        return userProfileDto;
    }

    public void setUserProfileDto(UserProfileDto userProfileDto) {
        this.userProfileDto = userProfileDto;
    }

    public Collection<PostDto> getPostDtos() {
        return postDtos;
    }

    public void setPostDtos(Collection<PostDto> postDtos) {
        this.postDtos = postDtos;
    }

    public Collection<RoleUserDto> getRoleUserDtos() {
        return roleUserDtos;
    }

    public void setRoleUserDtos(Collection<RoleUserDto> roleUserDtos) {
        this.roleUserDtos = roleUserDtos;
    }


}
