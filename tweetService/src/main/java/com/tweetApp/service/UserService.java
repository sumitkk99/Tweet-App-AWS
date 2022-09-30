package com.tweetApp.service;

import java.util.List;

import com.tweetApp.bean.User;

public interface UserService {

	List<User> getAllUsers();

	User register(User request);

	User forgetPassword(User request);

	User searchUser(String username);

	void logout(String loginId);
}
