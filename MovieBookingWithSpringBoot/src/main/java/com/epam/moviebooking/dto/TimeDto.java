package com.epam.moviebooking.dto;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "showtiming")
public class TimeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int timeId;
	LocalTime time;
	
	public TimeDto() {
		super();
	}
	public TimeDto(int timeId, LocalTime time) {
		super();
		this.timeId = timeId;
		this.time = time;
	}
	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

}
