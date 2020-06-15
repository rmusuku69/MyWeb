package com.galaxe.dao;
import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.galaxe.model.RegistrationDetails;

@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean save(final RegistrationDetails registrationDetails) {
		String query="insert into userdetails values(?,?,?,?,?)";
		
		
            return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
				preparedStatement.setString(1, registrationDetails.getName());
				preparedStatement.setString(2, registrationDetails.getEmail());
				preparedStatement.setString(3,registrationDetails.getContact());
				preparedStatement.setString(4, registrationDetails.getUsername());
				preparedStatement.setString(5, registrationDetails.getPassword());
				int updatedrows=preparedStatement.executeUpdate();
				if(updatedrows==1)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		});
	}
	/*@Override
	public ArrayList<Object> authenticate(final String username, final String password) {
		final String query="select * from userdetails where Username=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<ArrayList<Object>>(){
			@Override
			public ArrayList<Object> doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
				ArrayList<Object> arraylist=new ArrayList<Object>();
				preparedStatement.setString(1, username);
				try{
			    ResultSet resultSet=preparedStatement.executeQuery();
			    resultSet.next();
			    String password_fromDB=resultSet.getString("Password");
			    if(password_fromDB.equals(password)){
			    	resultSet.beforeFirst();
			    	resultSet.next();
			    	int columns=resultSet.getMetaData().getColumnCount();
			    	for(int i=1;i<=columns;i++)
			    	{
			    		arraylist.add(resultSet.getString(i));
			    	}
			    	return arraylist;
			    }
			    else{
			    	return null;
			    }}catch(Exception e){
			    	return null;
			    }
			}
		});
	}*/
	
	@Override
	public ArrayList<Object> authenticate(final String username, final String password) {
		final String query="select * from userdetails";
		List<Map<String,Object>> mapList=jdbcTemplate.queryForList(query);
		List<Object> list=new ArrayList<Object>();
		for(Map<String, Object> map :mapList)
		{
			list.addAll(map.values());
		}
		System.out.println(list.get(0));
		return (ArrayList<Object>) list;
	}
	
	
	
	@Override
	public List<Object> viewAllUsers() {
		String query="select * from userdetails";
		List<Map<String, Object>> mapList=jdbcTemplate.queryForList(query);
		List<Object> list=new ArrayList<Object>();
		for(Map<String, Object> map :mapList)
		{
			list.addAll(map.values());
		}
		return list;
	}
	@Override
	public List<Object> getDetailsByParam(String param, String constrain) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(RegistrationDetails details) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

}
