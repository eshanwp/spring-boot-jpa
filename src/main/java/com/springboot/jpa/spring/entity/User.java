package com.springboot.jpa.spring.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User{
    private int id;
    private String email;
    private String userName;
    private String password;
    private Collection<Post> postsById;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, userName, password);
    }

    @OneToMany(mappedBy = "userByUserId", cascade = CascadeType.ALL)
    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<RoleUser> getRoleUsersById() {
        return roleUsersById;
    }

    public void setRoleUsersById(Collection<RoleUser> roleUsersById) {
        this.roleUsersById = roleUsersById;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", postsById=" + postsById +
                ", roleUsersById=" + roleUsersById +
                '}';
    }
}
