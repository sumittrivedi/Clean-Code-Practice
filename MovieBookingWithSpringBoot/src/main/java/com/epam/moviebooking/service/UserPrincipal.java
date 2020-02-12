package com.epam.moviebooking.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.epam.moviebooking.entity.UserEntity;

public class UserPrincipal implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	private UserEntity userEntity;

	public UserPrincipal(UserEntity userDto) {
		super();
		this.userEntity = userDto;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(userEntity.getRole()));
	}

	@Override
	public String getPassword() {
		
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		
		return userEntity.getUsername();
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
