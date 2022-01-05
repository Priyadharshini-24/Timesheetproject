package com.timesheet.dao;

import java.util.List;

import com.timesheet.model.User;

public interface UserDAO {
	public boolean insertUser(User user);
	public User validateUser(String username,String password);
	public boolean updateUser(User user);
	public List<User> showalluser();
	public List<User> showuser(String username);
	public boolean removeUser(String username,String role);
	public int findUserId(String username);
}
