package com.tweetApp.service.implementation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.bean.Tweet;
import com.tweetApp.dto.Reply;
import com.tweetApp.repository.TweetRepo;
import com.tweetApp.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	TweetRepo tweetRepo;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
	SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");

	@Override
	public List<Tweet> getAllTweets() {
		// TODO Auto-generated method stub
		List<Tweet> tweets = (List<Tweet>) tweetRepo.findAll();
		return tweets;
	}

	@Override
	public List<Tweet> getAllTweetsByUserName(String userName) {
		List<Tweet> tweets = new ArrayList<>();
		try {
			tweets = tweetRepo.findByUserTweetId(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tweets;
	}

	@Override
	public Tweet addTweet(Tweet request, String userName) {
		Tweet tweet = new Tweet();
		List<Reply> reply = new ArrayList<>();
		Tweet maxEntity = tweetRepo.findTopByOrderByTweetIdDesc();
		if (maxEntity == null) {
			tweet.setTweetId(1l);
		} else {
			tweet.setTweetId(maxEntity.getTweetId() + 1);
		}
		tweet.setTweet(request.getTweet());
		tweet.setUserTweetId(userName);
		tweet.setLike(0l);
		tweet.setReply(reply);
		tweet.setDateOfPost(new Date());
		try {
			tweetRepo.save(tweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tweet;
	}

	@Override
	public String deleteTweet(String userName, Long tweetId) {
		try {
			tweetRepo.deleteByTweetId(tweetId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Successfully deleted";
	}

	@Override
	public Tweet replyToTweet(Tweet request) {
		Tweet existingTweet = new Tweet();
		List<Reply> replies = new ArrayList<>();
		try {
			existingTweet = tweetRepo.findByTweetId(request.getTweetId());
			replies.addAll(existingTweet.getReply());
			List<Reply> newReplies = request.getReply();
			newReplies.forEach(reply -> {
				reply.setDateReplied(new Date());
			});
			replies.addAll(newReplies);
			existingTweet.setReply(replies);
			tweetRepo.save(existingTweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existingTweet;
	}

	@Override
	public Tweet likeATweet(Tweet request) {
		Tweet existingTweet = new Tweet();
		try {
			existingTweet = tweetRepo.findByTweetId(request.getTweetId());
			existingTweet.setLike(existingTweet.getLike() + 1);
			tweetRepo.save(existingTweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existingTweet;
	}

	@Override
	public Tweet updateTweet(Tweet request) {
		Tweet existingTweet = new Tweet();
		try {
			existingTweet = tweetRepo.findByTweetId(request.getTweetId());
			existingTweet.setTweet(request.getTweet());
			tweetRepo.save(existingTweet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existingTweet;
	}

}
