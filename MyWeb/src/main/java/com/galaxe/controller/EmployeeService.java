package com.galaxe.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxe.dao.UserDao;
import com.galaxe.model.RegistrationDetails;

@Service
public class EmployeeService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean save(RegistrationDetails registrationDetails) {
		return userDao.save(registrationDetails);
	}

	public ArrayList<Object> authenticate(String username, String password) {
		return userDao.authenticate(username, password);
	}
	
	public List<Object> viewAllUsers() {
		return userDao.viewAllUsers();
	}

	public List<Object> getDetailsByParam(String param,String constrain) {
		return userDao.getDetailsByParam(param, constrain);
		
	}

	public boolean update(RegistrationDetails details){
		return userDao.update(details);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
}
