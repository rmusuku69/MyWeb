package com.galaxe.test;

import java.lang.reflect.Field;

import com.galaxe.model.RegistrationDetails;

public class FieldsTest {

	public static void main(String[] args) {
      RegistrationDetails registrationDetails=new RegistrationDetails();
      Field[] fields=registrationDetails.getClass().getDeclaredFields();
      String s=fields[0].getName();
      System.out.println(s);
	}

}
