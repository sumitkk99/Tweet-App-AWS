package com.tweetApp.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tweetApp.bean.User;
import com.tweetApp.repository.UserRepo;
import com.tweetApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> getAllUsers() {
		Iterable<User> users = new ArrayList<User>();
		try {
			users = userRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<User>) users;
	}

	@Override
	public User register(User request) {
		User newUser = new User();
		try {
			User user = userRepo.findByLoginId(request.getLoginId());
			List<String> roles = new ArrayList<>();
			roles.add("user");
			if (user == null) {
				newUser.setContactNumber(request.getContactNumber());
				newUser.setEmailId(request.getEmailId());
				newUser.setFirstName(request.getFirstName());
				newUser.setLastName(request.getLastName());
				newUser.setLoggedIn(false);
				newUser.setLoginId(request.getLoginId());
				newUser.setPassword(passwordEncoder().encode(request.getPassword()));
				newUser.setRoles(roles);
				userRepo.save(newUser);
			} else {
				System.out.println("User Already Exists");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return newUser;
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User forgetPassword(User request) {
		User existingUser = new User();
		try {
			existingUser = userRepo.findByLoginId(request.getLoginId());
			if (existingUser != null) {
				existingUser.setPassword(passwordEncoder().encode(request.getPassword()));
				userRepo.save(existingUser);
			} else {
				System.out.println("USER NOT FOUND");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existingUser;
	}

	@Override
	public User searchUser(String username) {
		User user = new User();
		try {
			user = userRepo.findByLoginId(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void logout(String loginId) {
		try {
			User existingUser = userRepo.findByLoginId(loginId);
			existingUser.setLoggedIn(false);
			userRepo.save(existingUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
