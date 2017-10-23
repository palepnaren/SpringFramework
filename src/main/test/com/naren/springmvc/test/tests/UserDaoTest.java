package com.naren.springmvc.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naren.springmvc.dao.User;
import com.naren.springmvc.dao.UserDAO;

@ActiveProfiles("development")
@ContextConfiguration(locations = { "classpath:com/naren/springmvc/test/config/bean.xml",
									"classpath:com/naren/springmvc/config/dao.xml", 
									"classpath:com/naren/springmvc/config/security-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private DataSource datasource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(datasource);
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
	}
	
	@Test
	public void dummyTest(){
		User user = new User("Naren","1234567",true,"user");
		
		assertTrue("Creating user", dao.createUser(user));
		
		List<User> users = dao.getUsers();
		for (User user2 : users) {
			assertEquals("Naren", user2.getUsername());
		}
		
		assertEquals("Number of users", 1, users.size());
	}

}
