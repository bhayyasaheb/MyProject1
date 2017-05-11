/*package com.niit.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private static Product product;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	
	@Test
	public void testCRUDProduct(){
		
		// create Operation
		product = new Product();
		
		product.setName("SAMSUNG Galaxy S8 Plus(Maple Gold, 64 GB 4 GB RAM)");
		product.setBrand("Samsung");
		product.setDescription("Boasting a top-notch security system featuring an Iris scanner, face recognition, fingerprint reader and more, the Galaxy S8 Plus keeps your private data safe from prying eyes. Its powerful 8 MP front camera and 12 MP rear camera");
		product.setUnitPrice(64900);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId("C555");
		product.setSupplierId("S102");
		
		assertEquals("Something went wrong while inserting a new product!",true,productDAO.add(product));
		
		
		// reading and updating the product
		
		product =productDAO.get(2);
		product.setQuantity(10);
		product.setUnitPrice(60000);
		
		assertEquals("Something went wrong while updating the existing record!",true,productDAO.update(product));
		
		// delete product
		
		assertEquals("Something went wrong while deleting the existing record!",true,productDAO.delete(product));
		
		//list of the product
		assertEquals("Something went wrong while fectching the list of products!",3,productDAO.list().size());
		
	}
	
	@Test
	public void testActiveProducts(){
		
		assertEquals("Something went wrong while fectching the list of Active products!",2,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testActiveProductsByCategory(){
		
		assertEquals("Something went wrong while fectching the list of Active products by category!",2,productDAO.listActiveProductsByCategory("C555").size());
		
		//assertEquals("Something went wrong while fectching the list of Active products by category!",3,productDAO.listActiveProductsByCategory(2).size());
		
		//assertEquals("Something went wrong while fectching the list of Active products by category!",3,productDAO.listActiveProductsByCategory(1).size());
	
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		
		assertEquals("Something went wrong while fectching the list of Active products!",2,productDAO.getLatestActiveProducts(2).size());
	}

}*/






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







