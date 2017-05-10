package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public boolean save(Product product) {
		
		try {
			getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		
		try {
			getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			getCurrentSession().delete(getProductById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		
		try {
			getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductById(String id) {
		try {
			return getCurrentSession().get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product getProductByName(String name) {
		try {
			return (Product) getCurrentSession().createQuery("from Product where name = ?").setString(0, name).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> list() {
		
		return getCurrentSession().createQuery("from Product").list();
	}

	public List<Product> getAllProductByCategoryID(String categoryID) {
		
		Query query = getCurrentSession().createQuery("from Product Where category_id=?");
		query.setString(0, categoryID);
		return query.list();
	}

	public List<Product> getAllProductBySupplierID(String supplierID) {
		Query query = getCurrentSession().createQuery("from Product where supplier_id=?");
		query.setString(0, supplierID);
		return query.list();
	}

	public List<Product> getSimilarProducts(String search_string) {
		// TODO Auto-generated method stub
		return null;
	}

}
