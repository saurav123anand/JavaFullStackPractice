package com.example.userms.repository;

import com.example.userms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);

    List<User> findByCity(String city);

    List<User> findByCityAndState(String city, String state);

    List<User> findByCityOrState(String city, String state);

    @Query("From User")
    List<User> getAllUsers();

    @Query("From User where name=:nameArg")
    List<User> findAllUsersByName(@Param("nameArg") String name);

    @Query(value = "select * from users", nativeQuery = true)
    List<User> getUsers();
}