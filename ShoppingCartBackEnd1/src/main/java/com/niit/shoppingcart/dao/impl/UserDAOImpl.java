package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e: sessionFactory
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	// This save method create a record in the user table if the record is
	// created successfully return true else will return false
	public boolean save(User user) {

		try {

			getSession().save(user);
			return true;
		} catch (Exception e) {
			// if any exception come during execute of try block,catch will
			// execute
			e.printStackTrace();
			return false;
		}

	}

	// This save method create a record in the user table if the record is
	// created successfully return true else will return false
	public boolean update(User user) {

		try {

			getSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	// validate method will return true if the credentials are correct else
	// will return false

	@SuppressWarnings("deprecation")
	public boolean validate(String id, String password) {

		Query query = getSession().createQuery("from User where id=? and password=?");
		query.setString(0, id);
		query.setString(1, password);
		// in the User table with this id and password there will one or zero
		// records will exists
		// i.e,uniqueResult
		// uniqueResult method will return object if a row exist , else it will
		// return null

		query.uniqueResult();

		if (query.uniqueResult() == null) {
			// means no row exists i.e.,invalid credentials
			return false;
		} else {
			// means row exists i.e., valid credentials
			return true;
		}

	}

	public List<User> list() {

		return getSession().createQuery("from User").list();
	}

	// get method get the data from user table based on primary key i.e., id
	// and set it to user class
	// like select * from user id=?
	public User getUser(String id) {

		try{
		return getSession().get(User.class, id);
		}catch(Exception e)
		{
			return null;
		}
	}

}
