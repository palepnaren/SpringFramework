package com.naren.springmvc.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naren.springmvc.dao.User;
import com.naren.springmvc.dao.UserDAO;

@Service("userService")
public class UsersService {

	
	private UserDAO dao;

	@Autowired
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public boolean create(User user){
		return dao.createUser(user);
	}
	
	public boolean exists(String username){
		return dao.isUsernameExists(username);
	}

	public List<User> getAllUsers() {
		
		return dao.getUsers();
	}
	
}
