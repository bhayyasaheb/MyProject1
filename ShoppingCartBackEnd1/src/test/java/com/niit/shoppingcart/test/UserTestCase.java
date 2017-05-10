package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserTestCase {

	@Autowired
	static User user;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static AnnotationConfigApplicationContext context;

	// above object need to initialize
	// This is method going execute before calling any one of test case and will
	// execute only once
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();
		// get userDAO from context
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	//@Test
	public void createUserTestCase() {

		
		user.setId("777");
		user.setName("Vikas");
		user.setPassword("Vikas@123");
		user.setRole("User");
		user.setMail("vikaskhasbage@gmail.com");
		user.setContact("9423551161");
		
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}
	@Test
	public void updateUserTestCase() {

		
		user.setId("222");
		user.setName("Mohan");
		user.setPassword("Mohan@123");
		user.setRole("User");
		user.setMail("mohanlohar63@gmail.com");
		user.setContact("7387828468");
		
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}
	
	@Test
	public void validateTestCase(){
		
		boolean flag=userDAO.validate("111", "SBK@123");
		assertEquals(true,flag);
	}
	
	@Test
	public void getUserTestCase(){
		
		 user=userDAO.getUser("333");
		 assertEquals(user.getClass().getName(),user.getClass().getName());
	}
	
	@Test
		public void getAllUserTestCase() {
			int actualSize = userDAO.list().size();

			// will compare actual and expected
			// if actual and expected is same - TC will pass
			// if it is different - TC fail
			assertEquals(6, actualSize);
		}

}








