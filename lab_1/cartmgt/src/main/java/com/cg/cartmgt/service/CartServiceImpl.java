package com.cg.cartmgt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cartmgt.dao.ICartDao;
import com.cg.cartmgt.entities.CartItem;

@Service
public class CartServiceImpl implements ICartService {

	private  ICartDao cartDao;
	
	public ICartDao getCartDao() {
		return cartDao;
	}

	@Autowired
	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public List<CartItem> fetchAllCartItems(int userId) {
		return cartDao.fetchAllCartItems(userId);
	}

	@Override
	public CartItem save(CartItem cartItem) {
		return cartDao.save(cartItem);
	}

}
