package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.MyCart;

@Controller
public class CartController {
	
	@Autowired MyCartDAO mycartDAO;
	
	@Autowired ProductDAO productDAO;
	
	
	@RequestMapping("ShowCart")
	public String showCartPage(Model m,HttpSession session)
	{
		
		String username = (String) session.getAttribute("username");
		List <MyCart> cartitems = (List<MyCart>) mycartDAO.getCartById(username);
		m.addAttribute("cartitems",cartitems);
		return "MyCart";
	}

}
