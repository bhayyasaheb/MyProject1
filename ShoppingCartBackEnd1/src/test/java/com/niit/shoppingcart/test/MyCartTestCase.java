package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;

public class MyCartTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static MyCart myCart;

	@Autowired static MyCartDAO myCartDAO;
	
	@BeforeClass
	public static void initialization(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		myCart = (MyCart) context.getBean("myCart");
		myCartDAO = (MyCartDAO) context.getBean("myCartDAO");
	}
	
	//@Test
	public void crateMyCartTestCase(){
		myCart.setId("M444");
		myCart.setUser_id("555");
		myCart.setProduct_name("Apple mackbook");
		myCart.setPrice(94000);
		myCart.setStatus("Y");
		myCart.setQuantity(1);
		myCart.setDate_added("26/04/2017");
		
		boolean flag = myCartDAO.save(myCart);
		assertEquals("createMyCartTestCase", true, flag);
	}
	
	//@Test
	public void updateMyCartTestCase(){
		
		myCart.setId("M111");
		myCart.setUser_id("222");
		myCart.setProduct_name("Hp Elitebook");
		myCart.setPrice(74000);
		myCart.setQuantity(1);
		myCart.setStatus("Y");
		myCart.setDate_added("26/04/2017");
		
		boolean flag = myCartDAO.update(myCart);
		assertEquals("updateMyCartTestCase", true, flag);
	}
	//@Test
	public void deleteMyCartTestCase(){
		
		boolean flag = myCartDAO.delete("M111");
		assertEquals("deleteMycartTestCase", true, flag);
	}
	
	//@Test
	public void getMyCartByIdTestCase(){
	
		myCart = myCartDAO.getCartById("M222");
		assertEquals(myCart.getClass().getName(), myCart.getClass().getName());
	}
	
	@Test
	public void getAllMyCartTestCase(){
		
		List <MyCart> cart = myCartDAO.list();
		assertEquals(4, cart.size());
	}
}




