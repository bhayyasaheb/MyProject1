package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired HttpSession session;
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;

	// get user id and password from login page
	// send these value to userDAO, validate
	// based on response you can navigate either to Login.jsp or Home.jsp

	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("username") String id, @RequestParam("password") String password)
	{
		log.debug("Staring of method login");
		
		log.info("You are login with the id"+id);
		
		ModelAndView mv = new ModelAndView("/Home");

		if (userDAO.validate(id, password) == true)
		{
			log.debug("Valid Credentials");
			
			user = userDAO.getUser(id);

			// ${message} to display in home.jsp
			mv.addObject("message", "Welcome " + user.getName());
			
			mv.addObject("categoryList",categoryDAO.list());
			mv.addObject("category",category);
			
			// check whether user is customer or admin
			
			if(user.getRole().equals("Admin"))
			{
				log.debug("You are Admin");
				mv.addObject("isAdmin","true");
			}
			else
			{
				log.debug("You are Customer");
				mv.addObject("isAdmin","false");
			}
			
		} else {
			log.debug("Invalid User");
			mv.addObject("message", "Invalid Credentials Please try Again ");
		}
		
		log.debug("Ending of the method login");
		return mv;
	}

	// we need to implement
	// create user
	// update user
	// getAllUsers
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user)
	{
		ModelAndView mv = new ModelAndView("Home");
		user.setRole("User");
		try {	
				userDAO.save(user);
				mv.addObject("message","Successfully Registered");
			
		} catch (Exception e) {
			mv.addObject("message","You Not able to Register this User Id All ready in Use");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		return mv;
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("forward:/");
		session.invalidate(); // will remove the attributes which are added
								// session
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
		log.debug("Ending of the method logout");
		return mv;
	}


	
	//@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	/*public String addUser(@ModelAttribute("form-reg") User user, Model model) {
	
		user.setRole("User");
		System.out.println("Hello");
		if (userDAO.save(user) == true) {

			model.addAttribute("message", "Successfully registred");
			model.addAttribute("registred", "true");
		} else {
			model.addAttribute("message", "not able to register");
		}
		return "Home";

	}*/

	
}
