package com.springboot.jpa.spring.dto;

import java.io.Serializable;
import java.util.List;

public class RoleUserDto implements Serializable {

    private String email;
    private List<RoleDto> roleDtos;

    public RoleUserDto(String email, List<RoleDto> roleDtos) {
        this.email = email;
        this.roleDtos = roleDtos;
    }

    public RoleUserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(List<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }
}
