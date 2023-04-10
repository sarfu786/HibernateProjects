package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.User;

public interface UserDao {

	public User saveUser(User user);
	
	public User getUserById(int uId);
	
	public boolean deleteUserById(int uId);
	
	public User updateUserById(int uId, User user);
	List<User> getAllUser();
	List<User> getUserByRole(String role);
}
