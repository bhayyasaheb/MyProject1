package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class HomeController {

	// whenever the user open our web site user navigate to home page
	// http://localhost:8080/ShoppingCart/

	
	@Autowired HttpSession session;
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired Category category;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Product product;
	
	@RequestMapping(value={"/","/Home"})
	public ModelAndView goToHomePage() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Shopping Cart");
		mv.addObject("isUserClickedHome", "true");
		
		
		// get all the category
		List <Category> categoryList = categoryDAO.list();
	
		// attach to session 	
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);
		
		// get all product
		List<Product> productList =productDAO.list();
		
		//attach to session 
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);
		
		return mv;
	}
	
	/*@RequestMapping("/Home")
	public String homePage(Model model) {
		model.addAttribute("isUserClickedHome", "true");
		return "Home";
	}*/
	
	@RequestMapping("/LoginPage")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");
		return "Home";
	}

	@RequestMapping("/SignUpPage")
	public String signUPPage(Model model) {
		model.addAttribute("isUserClickedSignUp", "true");
		return "Home";
	}
	@RequestMapping("/AboutUsPage")
	public String aboutUsPage(Model model)
	{
		model.addAttribute("isUserClickedAboutUs","true");
		return "Home";
	}
	@RequestMapping("/ContactUsPage")
	public String contactUsPage(Model model)
	{
		model.addAttribute("isUserClickedContactUs","true");
		return "Home";
	}
	
	@RequestMapping("/CartPage")
	public String cartPage(Model model) {
		model.addAttribute("isUserClickedCart", "true");
		return "Home";
	}
	@RequestMapping("/CheckoutPage")
	public String checkoutPage(Model model) {
		model.addAttribute("isUserClickedCheckout", "true");
		return "Home";
	}

}
