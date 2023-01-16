package com.training.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.springmvc.model.Cart;
import com.training.springmvc.model.Product;
import com.training.springmvc.model.User;
import com.training.springmvc.service.CartService;
import com.training.springmvc.service.LoginService;
import com.training.springmvc.service.ProductService;

@Controller

public class HelloController {
	
	@Autowired
	LoginService service;
	
	
	@Autowired
	ProductService pservice; 
	
	@Autowired
	CartService cservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("message", "LOGIN PAGE!");
		//map.addAttribute("message", "LOGIN PAGE!");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView Main() {
		ModelAndView mav8 = new ModelAndView("home");
		mav8.addObject("message", "HOME PAGE!");
		//map.addAttribute("message", "LOGIN PAGE!");
		return mav8;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayHello() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("message", "LOGIN PAGE!");
		//map.addAttribute("message", "LOGIN PAGE!");
		return mav;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView displayProduct() {
		ModelAndView mav = new ModelAndView("product");
		List<Product> products= pservice.getProducts();
		mav.addObject("allProducts", products);

		return mav;
	}
	
	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView displayProduct(ModelMap map, HttpServletRequest request  ,@ModelAttribute("user") User user) {
		//int userId=Integer.parseInt(request.getParameter("user_id"));
		//int userId=user.getUser_id();
		int userId=1;
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		if(service.validateUser(userName, password)) {
			map.addAttribute("name",userName);
			map.addAttribute("userId",userId);
			ModelAndView mav1 = new ModelAndView("product");
			List<Product> products= pservice.getProducts();
			mav1.addObject("allProducts", products);
			return mav1;
			}
		
		else if(userName.equals("") || password.equals("") ) {
			ModelAndView mav2 = new ModelAndView("error");
			return mav2;
			
		}
		
else {
	ModelAndView mav3 = new ModelAndView("fail");
	return mav3;
	}

	}
	
	
	
	@RequestMapping(value="/addtocart/{id}/{pname}/{desc}/{price}/{uid}", method = RequestMethod.GET)
	public String addToCart(ModelMap map ,@PathVariable("id") Integer id,@PathVariable("pname") String pname,@PathVariable("desc") String desc,@PathVariable("price") Double price, @PathVariable("uid") int uid, @ModelAttribute("cart") Cart cart, @ModelAttribute("user") User user) {
		
		cart.setProd_id(id);
		cart.setProd_name(pname);
		cart.setProd_desc(desc);
		cart.setPrice(price);
		
		cart.setUser_id(uid);
		
		if(cservice.createCart(cart)) {
			map.addAttribute("cartMsg", "Item Added Successfully");
			return "sucess";
	}

	else {
		map.addAttribute("cartMsg", "Error Not Added **");
		return "product";
}
}
	
	@RequestMapping(value = "/processCart", method = RequestMethod.GET)
	public ModelAndView displayCart(ModelMap map,HttpServletRequest request  ,@ModelAttribute("cart") Cart cart) {
		
		
		boolean carts=cservice.viewCart(cart);
		if(carts) {
			ModelAndView mav4 = new ModelAndView("cart");
			List<Cart> cartss = cservice.getCart(cart);
			mav4.addObject("cartss", cartss);
			return mav4;
}
else {
	ModelAndView mav5 = new ModelAndView("cart");
	return mav5;
	}

	}
	
//	@RequestMapping(value = "/processCart", method = RequestMethod.GET)
//	public ModelAndView displayCart(@PathVariable int userId) {
//		
//		ModelAndView mav4 = new ModelAndView("cart");
//		List<Cart> cartss = cservice.getCartList(1);
//		mav4.addObject("cartss", cartss);
//
//		for(Cart cart:cartss) {
//			System.out.println(cart.getProd_name());
//		}
//		return mav4;
//		
//
//	}
	
	
	
}
