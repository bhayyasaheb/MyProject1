package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Category category;

	@Autowired
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void inialization() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	//@Test
	public void createCategoryTestCase(){
		
		category.setId("C333");
		category.setName("LED");
		category.setDescription("samsung,panasonic,sony");
		
		boolean flag = categoryDAO.save(category);
		assertEquals("createCategoryTestCase", true, flag);
	}

	//@Test
	public void updateCategoryTestCase(){
		
		category.setId("C111");
		category.setName("Desktop");
		category.setDescription("Dell,Lenevo,Apple,Hp,Asus,Mackbook");
		
		boolean flag = categoryDAO.update(category);
		assertEquals("updateCategoryTestCase", true, flag);
	}
	
	//@Test
	public void deleteCategoryByIdTestCase(){
		
		boolean flag = categoryDAO.delete("C444");
		assertEquals("deleteCategoryById", true, flag);
	}
	
	//@Test
	public void deleteCategoryTestCase(){
		
		category.setName("Mobile");
		boolean flag = categoryDAO.delete(category);
		assertEquals("deleteCategoryTestCase", true, flag);
	}
	
	@Test
	public void getCategoryByIdTestCase(){
		
		category =categoryDAO.getCategoryById("C555");
		assertEquals(category.getClass().getName(), category.getClass().getName());
	}
	
	@Test
	public void getCategoryByNameTestcase(){
		
		category = categoryDAO.getCategoryByName("Laptop");
		assertEquals(category.getClass().getName(), category.getClass().getName());
	}
	
	@Test
	public void getAllCategoryTestCase(){
		
		List<Category> categories = categoryDAO.list();
		assertEquals(7, categories.size());
	}
}








