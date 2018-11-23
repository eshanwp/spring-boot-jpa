package com.springboot.jpa.spring.service;

import com.springboot.jpa.spring.converter.RoleConverter;
import com.springboot.jpa.spring.dto.RoleDto;
import com.springboot.jpa.spring.dto.RoleUserDto;
import com.springboot.jpa.spring.entity.Role;
import com.springboot.jpa.spring.entity.User;
import com.springboot.jpa.spring.repository.RoleRepository;
import com.springboot.jpa.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //Get all role
    public List<RoleDto> getAllRole() {
        return roleRepository.findAll().stream().map(RoleConverter::entityToDto).collect(Collectors.toList());
    }

    //Get role by user id
    public HashMap getRoleByUserId(Integer id) {

        HashMap hashMap = new HashMap();

        //Get the Role details with role
        List<Object> list = userRepository.getRoleByUserId(id);

        if (list.size()>0){

            Object[] row = (Object[]) list.get(0);
            User user = (User) row[0];
            RoleUserDto model = new RoleUserDto();

            hashMap.put("email", user.getEmail());

            List<Role> roleList = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                Object aList = list.get(i);

                Object[] rowRole = (Object[]) aList;

                Role roleDto = (Role) rowRole[1];

                roleList.add(roleDto);
                model.setRoleDtos(roleList.stream().map(RoleConverter::entityToDto).collect(Collectors.toList()));
                hashMap.put("role", model.getRoleDtos());
            }

        }

        return hashMap;
    }
}

