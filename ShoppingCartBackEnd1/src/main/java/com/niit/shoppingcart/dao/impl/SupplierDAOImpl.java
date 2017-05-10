package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public boolean save(Supplier supplier) {
		try {
			getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			getCurrentSession().delete(getSupplierById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {
			getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierById(String id) {
		try{
		return getCurrentSession().get(Supplier.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public Supplier getSupplierByName(String name) {
		
		//return (Supplier) getCurrentSession().createQuery("from supplier where name='"+name+"'");
		try{
		Query query = getCurrentSession().createQuery("from Supplier Where name=?");
		query.setString(0, name);
		return (Supplier) query.uniqueResult();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Supplier> list() {
		
		return getCurrentSession().createQuery("from Supplier").list();
	}
	

}
