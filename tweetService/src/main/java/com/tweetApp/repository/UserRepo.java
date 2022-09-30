package com.tweetApp.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.tweetApp.bean.User;

@EnableScan
public interface UserRepo extends CrudRepository<User, String> {

	User findByLoginId(String loginId);
}
