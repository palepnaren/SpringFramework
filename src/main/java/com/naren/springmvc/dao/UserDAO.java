package com.naren.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean createUser(User user){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("enable", user.isEnable());
		params.addValue("authorization", user.getAuthorization());
		
		jdbc.update("insert into users(username,password,enable) values(:username,:password,:enable)", params);
		
		return jdbc.update("insert into authorities values(:username,:authorization)", params) == 1;
		
	}
	
	public boolean isUsernameExists(String username){
		
		return jdbc.queryForObject("select count(*) from users where username = :username",
				new MapSqlParameterSource("username", username), Integer.class) == 1;
	}

	public List<User> getUsers() {
		
		return jdbc.query("select * from users as u,authorities as a where u.username = a.username", new BeanPropertyRowMapper<User>(User.class) );

	}

}

//new BeanPropertyRowMapper<User>(){			
//public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
//	
//	User user = new User();
//	user.setUsername(rs.getString("username"));
//	user.setEnable(rs.getBoolean("enable"));
//	user.setAuthorization(rs.getString("authorization"));
//	return user;
//}
//}
