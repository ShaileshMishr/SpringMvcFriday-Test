package com.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.model.Cart;
import com.training.springmvc.repository.CartRepository;

@Service
public interface CartService {
	public static final CartRepository cartRepository = null;

	boolean createCart(Cart cart);

	boolean viewCart(Cart cart);

	 List<Cart> getCarts(Cart cart) ;
//		List<Cart> carts = (List<Cart>)cartRepository.findAll();
//			return carts;
//		}

	List<Cart> getCarts();
}
