package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date dateOfBirth;

	private String userName;

	private boolean admin;

	private User[] subordinateArray;

	private int rating;

	public User(String userName) {
		super();
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", userName=" + userName + ", admin=" + bAdmin + ", subordinateArray="
				+ Arrays.toString(subordinateArray) + ", rating=" + rating + "]";
	}

}
