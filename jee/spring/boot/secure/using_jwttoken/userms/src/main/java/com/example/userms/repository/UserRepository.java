package com.example.userms.repository;

import com.example.userms.entity.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;

import javax.swing.text.html.Option;
import java.util.Optional;

@Validated
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(@Length(min = 2,max = 15) String username);
}
