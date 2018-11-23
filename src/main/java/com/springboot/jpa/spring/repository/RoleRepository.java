package com.springboot.jpa.spring.repository;

import com.springboot.jpa.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

}
