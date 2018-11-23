package com.springboot.jpa.spring.controller;

import com.springboot.jpa.spring.dto.RoleDto;
import com.springboot.jpa.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //Get all role
    @GetMapping(value = "/users/roles")
    public List<RoleDto> getAllRole(){
        return roleService.getAllRole();
    }
}
