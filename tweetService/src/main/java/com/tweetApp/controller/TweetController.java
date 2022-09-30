package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.bean.Tweet;
import com.tweetApp.service.TweetService;

//@CrossOrigin(origins = "http://${localhost}:3000")
@RestController
public class TweetController {

	@Autowired
	TweetService tweetService;

	@GetMapping(value = "/api/v1.0/tweets/all")
	public List<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}

	@GetMapping(value = "/api/v1.0/tweets/{username}")
	public List<Tweet> getAllTweetsUser(@PathVariable("username") String userName) {
		return tweetService.getAllTweetsByUserName(userName);

	}

	@PostMapping(value = "/api/v1.0/tweets/{username}/add")
	public Tweet addTweet(@RequestBody Tweet request, @PathVariable("username") String userName) {
		return tweetService.addTweet(request, userName);
	}

	@RequestMapping(path = "/api/v1.0/tweets/{username}/delete/{id}", method = RequestMethod.DELETE)
	public String deleteTweet(@PathVariable("username") String userName, @PathVariable("id") Long tweetId) {
		return tweetService.deleteTweet(userName, tweetId);

	}

	@PostMapping(value = "/api/v1.0/tweets/reply")
	public Tweet replyToTweet(@RequestBody Tweet request) {
		return tweetService.replyToTweet(request);
	}

	@RequestMapping(value = "/api/v1.0/tweets/like", method = RequestMethod.POST)
	public Tweet likeATweet(@RequestBody Tweet request) {

		return tweetService.likeATweet(request);
	}

	@RequestMapping(value = "/api/v1.0/tweets/update", method = RequestMethod.POST)
	public Tweet updateTweet(@RequestBody Tweet request) {
		return tweetService.updateTweet(request);
	}

}
