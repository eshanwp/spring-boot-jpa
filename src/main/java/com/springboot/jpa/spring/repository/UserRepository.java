package com.springboot.jpa.spring.repository;

import com.springboot.jpa.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //Get the user and user profile by using JPA Join Query
    @Query("SELECT U,P FROM User U, UserProfile P WHERE U.id = P.userId")
    List<Object> findByUserProfile();

    //Get the user and user profile by using Native Query

    //@Query(
    //        value = "SELECT user.user_name, user_profile.address1 FROM user INNER JOIN user_profile ON user.id = user_profile.user_id",
    //        nativeQuery = true)

    //Get the user and user profile by using JPA Join Query with where clause
    @Query("SELECT U,P FROM User U, UserProfile P WHERE U.id = P.userId AND P.userId = :userId")
    List<Object> getProfileByUserId(@Param("userId") int userId);

    //Get the user and role details
    @Query("SELECT U,R FROM User U, Role R, RoleUser RU WHERE U.id = RU.userId AND R.id = RU.roleId AND U.id = :userId")
    List<Object> getRoleByUserId(@Param("userId") int userId);
}
