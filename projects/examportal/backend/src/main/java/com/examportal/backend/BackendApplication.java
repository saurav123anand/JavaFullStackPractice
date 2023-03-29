package com.examportal.backend;

import com.examportal.backend.exceptions.UserAlreadyExists;
import com.examportal.backend.models.Role;
import com.examportal.backend.models.User;
import com.examportal.backend.models.UserRole;
import com.examportal.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	@Autowired
	private IUserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("starting code...");
			User user = new User();
			user.setFirstName("Scooby");
			user.setLastName("Scoob");
			user.setUsername("root");
			user.setPassword(bCryptPasswordEncoder.encode("root@123"));
			user.setEmail("scooby@gmail.com");
			user.setPhone("8956452376");
			user.setProfile("default.png");

			Role role = new Role();
			role.setRoleId(44L);
			role.setRoleName("ADMIN");

			Set<UserRole> userRoles = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);
			userRoles.add(userRole);

			userService.createUser(user, userRoles);
		}
		catch (UserAlreadyExists e){
			e.printStackTrace();
		}

	}
}
