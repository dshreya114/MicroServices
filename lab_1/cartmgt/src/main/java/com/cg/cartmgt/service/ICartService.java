package com.cg.cartmgt.service;

import java.util.List;
import com.cg.cartmgt.entities.CartItem;

public interface ICartService {
	
	List<CartItem>  fetchAllCartItems(int  userId);
	
	CartItem save(CartItem cartItem);
}
