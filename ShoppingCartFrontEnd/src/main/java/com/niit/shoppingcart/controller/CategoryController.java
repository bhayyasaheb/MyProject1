package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CategoryController {

	// create category
	// update category
	// delete category
	// fetch all categories
	
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired CategoryDAO categoryDAO;
	
	@Autowired Category category;
	
	@Autowired HttpSession session;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Product product;
	
	/*--------------------------- Create Category ----------------------------------*/
	
	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description, RedirectAttributes redirectAttributes)
	{
		log.debug("Starting of the method createCategory");
		
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
		//mv.addObject("isAdminClickedCategories","true");
		//mv.addObject("isAdmin","true");
		
		// Before calling the save method check whether save method is exist in db or not
		
		// if it is does not exist, then only call save method
		
		if (categoryDAO.getCategoryById(id) != null) 
		{
			log.debug("Category All ready Exist in Database");
			// category already exist
			//mv.addObject("message","Category Already Exist with the id "+id);
			redirectAttributes.addFlashAttribute("message","Category Already Exist with the id "+id);
			return mv;
		}
		else //actually else is not requied if return statement is there in if condition
		{
			categoryDAO.save(category);
			log.debug("Category Saved Successfully");
			//mv.addObject("message","Category Created Successfully"+id);
			redirectAttributes.addFlashAttribute("message","Category Created Successfully"+id);
		}
		
		//session.setAttribute("categoryList", categoryDAO.list());
		//session.setAttribute("category", category);
		
		log.debug("Ending of the method  createCategory");
		
		return mv;
	}
	
	
	/*------------------------------------- Delete Category -------------------------------*/
	// attached to url with path variable
	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
		
		log.debug("Staring of the method delete Category");
		
		log.debug("You are going to delete "+id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		//mv.addObject("isAdmin","true");
		//mv.addObject("isAdminClickedCategories","true");
		
		// check whether the product are there for this category or not
		
		int size = productDAO.getAllProductByCategoryID(id).size();
		if(size !=0)
		{
			log.debug("Few Product is under this Category, You can not delete");
			//mv.addObject("message","There are "+size+" Product is under this Category "+id+" You can not delete");
			redirectAttributes.addFlashAttribute("message","There are "+size+" Product is under this Category "+id+" You can not delete");
			return mv;	
		}
		
		
		if (categoryDAO.delete(id)==true) 
		{
			//mv.addObject("message"," Successfully deleted the category");
			redirectAttributes.addFlashAttribute("message"," Successfully deleted the category");
		}
		else 	
		{
			//mv.addObject("message","Not able to Delete the Category");
			redirectAttributes.addFlashAttribute("message","Not able to Delete the Category");
		}
		
		//session.setAttribute("categoryList", categoryDAO.list());
		//session.setAttribute("category", category);
		
		log.debug("Ending of the method delete Category");
		
		return mv;
	}
	
	
	
	/*------------------------------------Edit Category -----------------------------------*/
	
	//http://localhost:8080/ShoppingCartFrontEnd/manage_categories_category_edit/C66
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id)
	{
		log.debug("Starting of method Edit Categories");
		
		log.debug("Going to Edit the Category : "+id);
		
		category = categoryDAO.getCategoryById(id);
		
		//selected category details stored in another instance
		//in ModelAndView instance
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
		mv.addObject("selectedCategory",category);
		session.setAttribute("selectedCategory", category);
		
		log.debug("Ending of the method Edit Category");
		
		return mv;
	}
	
	
	/*---------------------------------Update Category -------------------------------------------------------------*/
	
	
	//@RequestMapping("/manage_category_edit/manage_category_update")
	@PostMapping("/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description, RedirectAttributes redirectAttributes)
	{
		log.debug("Starting of the method updateCategory");
		
		log.debug("Going to edit the category : "+id);
		
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		
		//mv.addObject("isAdminClickedCategories","true");
		//mv.addObject("isAdmin","true");
		
		// Before calling the update method check whether id  is exist in db or not
		
		// if it is  exist, then only call update method
		
		if (categoryDAO.getCategoryById(id) == null) 
		{
			log.debug("Category does not Exist with  in Database");
			// category does not exist
			//mv.addObject("message","Category does not Exist with the id "+id);
			redirectAttributes.addFlashAttribute("message","Category does not Exist with the id "+id);
			return mv;
		}
		else //actually else is not requied if return statement is there in if condition
		{
			categoryDAO.update(category);
			//mv.addObject("message","Category Updated Successfully with id :"+id);
			redirectAttributes.addFlashAttribute("message","Category Updated Successfully with id :"+id);
			log.debug("Category Updated Successfully");
		}
		
		//session.setAttribute("categoryList", categoryDAO.list());
		//session.setAttribute("category", category);
		session.setAttribute("selectedCategory", new Category());
		
		log.debug("Ending of the method  updateCategory");
		
		return mv;
	}
}























