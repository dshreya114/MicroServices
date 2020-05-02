package com.cg.cartmgt.dao;

import java.util.List;
import com.cg.cartmgt.entities.CartItem;

public interface ICartDao {

	List<CartItem>  fetchAllCartItems(int  userId);
	
	CartItem save(CartItem cartItem);
	
}
