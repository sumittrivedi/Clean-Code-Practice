package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.entity.UserEntity;
import com.epam.moviebooking.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserEntity> userDto = userRepository.findById(username);
		if(! userDto.isPresent())
			throw new UsernameNotFoundException("UserName is incorrect");
	
		return new UserPrincipal(userDto.get());
	}
	
	public void addUser(String username, String password)
	{
		UserEntity userDto = new UserEntity();
		userDto.setUsername(username);
		userDto.setPassword(password);
		userDto.setRole("USER");
		userRepository.save(userDto);
	}

}
