package com.springboot.jpa.spring.converter;

import com.springboot.jpa.spring.dto.RoleDto;
import com.springboot.jpa.spring.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role dtoToEntity(RoleDto roleDto){

        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        return role;

    }

    public static RoleDto entityToDto(Role role){

        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setDescription(role.getDescription());
        return roleDto;

    }
}
