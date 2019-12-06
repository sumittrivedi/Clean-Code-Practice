package com.epam.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.moviebooking.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String>
{


}
