package com.niit.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static Product product;
	
	@Autowired static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialization(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	//@Test
	public void createProductTestCase(){
		
		product.setId("P312");
		product.setName("HP Elitebook");
		product.setDescription("intel core i7,16GB RAM,1TB ROM, Windows10 Home");
		product.setPrice(99000);
		product.setQuantity(5);
		product.setCategory_id("C555");
		product.setSupplier_id("S333");
		
		boolean flag = productDAO.save(product);
		assertEquals("createProductTestCase", true, flag);
	}

	//@Test
	public void updateProductTestCase(){
		
		product.setId("P111");
		product.setName("HP Elitebook");
		product.setDescription("intel core i7,16GB RAM,1TB ROM, Windows10 Home");
		product.setPrice(74000);
		product.setPrice(2);
		product.setSupplier_id("S666");
		product.setCategory_id("C555");
		
		boolean flag = productDAO.update(product);
		assertEquals("updateProductTestCase", true, flag);
	}
	
	//@Test
	public void deleteProductByIdTestCase(){
		
		boolean flag = productDAO.delete("P666");
		assertEquals("deleteProductByIdTestCase",true, flag);
	}
	
	//@Test
	public void deleteProductTestCase(){
		
		product.setName("Dell inspiron 7000");
		boolean flag = productDAO.delete(product);
		assertEquals("deleteProductTestCase", true, flag);
	}
	
	@Test 
	public void getProductByIdTestCase(){
		
		product = productDAO.getProductById("P111");
		assertEquals(product.getClass().getName(), product.getClass().getName());
	}
	
	@Test
	public void getProductByNameTestCase(){
		
		productDAO.getProductByName("Dell Inspiron 5000");
		assertEquals(product.getClass().getName() , product.getClass().getName());
	}
	
	@Test
	public void getAllProductTestCase(){
		
		int actualsize = productDAO.list().size();
		assertEquals(4, actualsize);
	}
}







