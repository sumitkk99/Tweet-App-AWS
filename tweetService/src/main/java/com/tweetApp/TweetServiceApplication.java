package com.tweetApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweetServiceApplication {

	public static void main(String[] args) {
		System.out.println("starting tweet application");
		SpringApplication.run(TweetServiceApplication.class, args);
	}

}
