package com.cg.cartmgt.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.cg.cartmgt.entities.CartItem;

@Repository
public class CartDaoImpl implements ICartDao{

	private  Map<Integer, CartItem> store =new  HashMap<>();
	@Override
	public List<CartItem> fetchAllCartItems(int userId) {
		Collection<CartItem> items = store.values();
		List<CartItem>  list = new ArrayList<>();
		
		for(CartItem  item:items)
		{
			if(item.getUserId() == userId)
			{
				list.add(item);
			}
		}
		return list;
		
	}
	
	@Override
	public CartItem save(CartItem cartItem) {
		int id = generateId();
		cartItem.setCartId(id);
		store.put(cartItem.getCartId(), cartItem);
		return cartItem;
	}

	private int generateId;
	
	public int generateId()
	{
		return generateId++;
	}
}
