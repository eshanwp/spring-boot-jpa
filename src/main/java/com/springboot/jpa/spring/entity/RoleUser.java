package com.springboot.jpa.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_user", schema = "spring_boot_jpa")
@IdClass(RoleUserPK.class)
public class RoleUser {
    private int userId;
    private int roleId;
    private User userByUserId;
    private Role roleByRoleId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser roleUser = (RoleUser) o;
        return userId == roleUser.userId &&
                roleId == roleUser.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    @JsonProperty
    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    @JsonProperty
    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
