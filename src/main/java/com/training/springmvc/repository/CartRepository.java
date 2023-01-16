package com.training.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springmvc.model.Cart;
import com.training.springmvc.model.User;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	// public interface CartRepository extends JpaRepository<User, Integer>{
	//public Cart findById(int user_id);
}
