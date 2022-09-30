package com.tweetApp.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.tweetApp.bean.Tweet;

@EnableScan
public interface TweetRepo extends CrudRepository<Tweet, String> {

	List<Tweet> findByUserTweetId(String userName);

	void deleteByTweetId(Long tweetId);

	Tweet findByTweetId(Long tweetId);

	Tweet findTopByOrderByTweetIdDesc();

}
