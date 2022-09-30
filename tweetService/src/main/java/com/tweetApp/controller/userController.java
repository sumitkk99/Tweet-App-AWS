package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.bean.User;
import com.tweetApp.service.UserService;

//@CrossOrigin("http://${localhost}:3000")
@RestController
public class userController {

	@Autowired
	UserService userService;

	@RequestMapping(path = "/api/v1.0/tweets/users/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public User register(@RequestBody User request) {
		return userService.register(request);
	}

	@RequestMapping(path = "/forgetPassword", method = RequestMethod.POST)
	public User forgetPassword(@RequestBody User request) {
		return userService.forgetPassword(request);
	}

	@RequestMapping(path = "/api/v1.0/user/search/{username}", method = RequestMethod.GET)
	public User searchUsers(@PathVariable(name = "username") String username) {
		return userService.searchUser(username);
	}

	@RequestMapping(path = "/logout/{loginId}", method = RequestMethod.GET)
	public void logout(@PathVariable(name = "loginId") String loginId) {
		userService.logout(loginId);
	}

}
