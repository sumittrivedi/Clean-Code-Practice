package com.epam.moviebooking.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.epam.moviebooking.dto.UserDto;

public class UserPrincipal implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	private UserDto userDto;

	public UserPrincipal(UserDto userDto) {
		super();
		this.userDto = userDto;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		
		return userDto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
			return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
