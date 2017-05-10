package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.MyCart;

public interface MyCartDAO {

	// save cart
	public boolean save(MyCart mycart);

	// update cart
	public boolean update(MyCart myCart);

	// delete cart
	public boolean delete(String id);

	// get cart by id
	public MyCart getCartById(String id);

	// get all cart list
	public List<MyCart> list();
	
	public Long getTotalAmount(String user_id);
	
	public Long getMaxId();

}
