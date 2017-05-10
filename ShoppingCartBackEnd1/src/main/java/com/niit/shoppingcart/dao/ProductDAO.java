package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	// create Product
	public boolean save(Product product);
	
	// update Product
	public boolean update(Product product);
	
	// delete Product by id
	public boolean delete(String id);
	
	// delete Product by Product
	public boolean delete(Product product);
	
	// get Product by id
	public Product getProductById(String id);
	
	//get Product by name
	public Product getProductByName(String name);
	
	// get all the Product
	public List<Product> list();
	
	// get all product based on particular category
	public List<Product> getAllProductByCategoryID(String Id);
	
	// get all Product based on particular supplier
	public List<Product> getAllProductBySupplierID(String Id);

	public List<Product> getSimilarProducts(String search_string);
}
