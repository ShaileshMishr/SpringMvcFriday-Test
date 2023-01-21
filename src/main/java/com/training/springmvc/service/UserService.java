package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.model.User;
import com.training.springmvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
	
		List<User> users = (List<User>)userRepository.findAll();
		return users;
	}	
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public int getUserId(String userName, String password) {
		List<User> users = (List<User>)userRepository.findAll();
		int userid = 0;
		for(User usr: users) {
			if(usr.getUser_name().equals(userName) && usr.getUser_pwd().equals(password))
			{
				userid=usr.getUser_id();
			}
		}
		return userid;
		}

}
