package com.epam.moviebooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.moviebooking.dto.UserDto;
import com.epam.moviebooking.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserDto> userDto = userRepository.findById(username);
		if(userDto.isPresent() == false)
			throw new UsernameNotFoundException("UserName is incorrect");
	
		return new UserPrincipal(userDto.get());
	}

}
