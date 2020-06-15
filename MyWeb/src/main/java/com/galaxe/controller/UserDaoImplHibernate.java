package com.galaxe.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.galaxe.dao.UserDao;
import com.galaxe.model.RegistrationDetails;

@Repository
public class UserDaoImplHibernate implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public boolean save(RegistrationDetails registrationDetails) {
		Session session=sessionFactory.openSession();
		try{
		session.getTransaction().begin();
		session.save(registrationDetails);
		session.getTransaction().commit();
		session.close();
		return true;
		}
		catch(Exception e)
		{
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public ArrayList<Object> authenticate(String username, String password) {
		try{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(RegistrationDetails.class);
		criteria.add(Restrictions.eq("username",username));
		List<Object> list=criteria.list();
		session.close();
		RegistrationDetails details=(RegistrationDetails) list.get(0);
		if(password.equals(details.getPassword()))
			return (ArrayList<Object>) list;
		else
			return null;
		}catch(Exception e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> viewAllUsers() {
		Session session=sessionFactory.openSession();
		List<Object> list=session.createCriteria(RegistrationDetails.class).list();
		session.close();
		return list ;
	}

	@Override
	public List<Object> getDetailsByParam(String param,String constrain) {
		try{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(RegistrationDetails.class);
		RegistrationDetails registrationDetails=new RegistrationDetails();
		Field[] fieldsList=registrationDetails.getClass().getDeclaredFields();
		for(int i=0;i<fieldsList.length;i++)
		{
			if(constrain.equals(fieldsList[i].getName()) && !(constrain.equals("id"))){
				criteria.add(Restrictions.like(constrain, param,MatchMode.START));
				break;
			}
		}
		if(constrain.equals("id")){
			criteria.add(Restrictions.eq("id",new Integer(Integer.parseInt(param)) ));
			}
		List<Object> list=criteria.list();
		session.close();
		return list;}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean update(RegistrationDetails details){
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(details);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public void deleteUserById(int id) {
        Session session=sessionFactory.openSession();
        RegistrationDetails registrationDetails=(RegistrationDetails) session.get(RegistrationDetails.class, id);
        session.getTransaction().begin();
        session.delete(registrationDetails);
        session.getTransaction().commit();
        session.close();
	}
}
