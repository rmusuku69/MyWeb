package com.galaxe.dao;

import java.util.ArrayList;
import java.util.List;

import com.galaxe.model.RegistrationDetails;

public interface UserDao {
	
	 boolean save(RegistrationDetails registrationDetails);
	 ArrayList<Object> authenticate(String username,String password);
	 List<Object> viewAllUsers();
	 List<Object> getDetailsByParam(String param,String constrain);
	 boolean update(RegistrationDetails details);
	 void deleteUserById(int id);
}
