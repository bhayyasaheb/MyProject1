package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	
	// create category
	public boolean save(Category category);
	
	// update category
	public boolean update(Category category);
	
	// delete Category by id
	public boolean delete(String id);
	
	//delete Category by Category
	public boolean delete(Category category);
	
	//get category by id
	public Category getCategoryById(String id);
	
	// get Category by name
	public Category getCategoryByName(String name);
	
	//  get All Category
	public List<Category> list();

}
