package com.tweetApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetApp.bean.User;
import com.tweetApp.repository.UserRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepository;

	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		User user = userRepository.findByLoginId(loginId);
		if (user.getLoginId() == null) {
			throw new UsernameNotFoundException(loginId);
		} else {
			AppUser appUser = new AppUser(user);
			return appUser;
		}
	}
}
