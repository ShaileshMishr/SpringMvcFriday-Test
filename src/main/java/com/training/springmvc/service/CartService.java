package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.model.Cart;
import com.training.springmvc.repository.CartRepository;

@Service
public interface CartService {

	boolean createCart(Cart cart);

	boolean viewCart(Cart cart);

	 List<Cart> getCart(Cart cart) ;

//	 public List<Cart> getCartList(int id);
}
