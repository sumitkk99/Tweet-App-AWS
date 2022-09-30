package com.tweetApp.service;

import java.util.List;

import com.tweetApp.bean.Tweet;

public interface TweetService {

	List<Tweet> getAllTweets();

	List<Tweet> getAllTweetsByUserName(String userName);

	Tweet addTweet(Tweet request, String userName);

	String deleteTweet(String userName, Long tweetId);

	Tweet replyToTweet(Tweet request);

	Tweet likeATweet(Tweet request);

	Tweet updateTweet(Tweet request);

}
