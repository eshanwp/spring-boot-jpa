package com.springboot.jpa.spring.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    private int id;
    private String name;
    private String description;
    private Collection<RoleUser> roleUsersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name) &&
                Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<RoleUser> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUser> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", roleUsersById=" + roleUsersById +
                '}';
    }
}
