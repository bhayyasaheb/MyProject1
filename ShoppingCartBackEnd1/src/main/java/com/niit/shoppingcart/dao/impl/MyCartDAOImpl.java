package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

@Transactional
@Repository("myCartDAO")
public class MyCartDAOImpl implements MyCartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public MyCartDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public boolean save(MyCart mycart) {

		try {
			getCurrentSession().save(mycart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(MyCart myCart) {
		try {
			getCurrentSession().update(myCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			getCurrentSession().delete(getCartById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MyCart getCartById(String id) {

		return getCurrentSession().get(MyCart.class, id);
	}

	public List<MyCart> list() {
	
		return getCurrentSession().createQuery("from MyCart").list();
	}

	public Long getTotalAmount(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getMaxId() {
		// TODO Auto-generated method stub
		return null;
	}

}
