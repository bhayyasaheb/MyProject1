/*package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	*//**
	 * Getting the single product based on id
	 *//*
	@Override	
	public Product get(int productId) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}


	*//**
	 * Get the List of All Category
	 *//*

	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	*//**
	 * Insert Product
	 *//*
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	*//**
	 * Update Product
	 *//*

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	*//**
	 * Delete Product
	 *//*

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			// call the update method
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public List<Product> getAllProductByCategoryID(String categoryID) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Product Where category_id=?");
		query.setString(0, categoryID);
		return query.list();
	}

	public List<Product> getAllProductBySupplierID(String supplierID) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where supplier_id=?");
		query.setString(0, supplierID);
		return query.list();
	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE active = :active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}


	@Override
	public List<Product> listActiveProductsByCategory(String categoryId) {

		String selectActiveProductsCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();

	}


	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}	

}
*/



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
