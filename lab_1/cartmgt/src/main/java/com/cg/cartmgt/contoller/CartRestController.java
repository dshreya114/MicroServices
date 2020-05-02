package com.cg.cartmgt.contoller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cg.cartmgt.dto.AddCartItemDto;
import com.cg.cartmgt.dto.CartItemDetailsDto;
import com.cg.cartmgt.dto.ProductDto;
import com.cg.cartmgt.entities.CartItem;
import com.cg.cartmgt.service.ICartService;

@RestController
@RequestMapping( "/cartitems")
public class CartRestController 
{
	//private static  Logger log = LoggerFactory.getLogger(CartRestController.class);
	@Autowired
	private  ICartService  service;
	
	@Value("${productservice.baseurl}")
	private  String productServiceBaseUrl;
	
	public String getProductServiceBaseUrl() {
		return productServiceBaseUrl;
	}

	public void setProductServiceBaseUrl(String productServiceBaseUrl) {
		this.productServiceBaseUrl = productServiceBaseUrl;
	}

	private RestTemplate   restTemplate;
	
	@PostMapping("/additem")
	public ResponseEntity<String>  addCartItem(@RequestBody  AddCartItemDto  dto)
	{
		CartItem cartItem = new  CartItem();
		cartItem.setUserId(dto.getUserId());
		cartItem.setProductId(dto.getProductId());
		  cartItem = service.save(cartItem);
		  String msg = "Cart Item added successfully.";
		  ResponseEntity<String> response = new  ResponseEntity<>(msg ,HttpStatus.OK);
		return response;
	}

	@GetMapping("/cartdetails/{userId}")
	public  ResponseEntity<List<CartItemDetailsDto>> cartDetails(@PathVariable("userId")  int userId )
	{
		List<CartItem> cartItems = service.fetchAllCartItems(userId);
		List<CartItemDetailsDto> list = new ArrayList<>();
	
		for(CartItem item: cartItems)
		{
		ProductDto productDto = fetchProductById(item.getProductId())	;
		CartItemDetailsDto  cartItemDetailsDto= cartItemDetailsDto(item,productDto);
		list.add(cartItemDetailsDto);
		}
	
		ResponseEntity<List<CartItemDetailsDto>> response = new  ResponseEntity<>(list , HttpStatus.OK);
		return response;
	}
	
	private ProductDto fetchProductById(String productId) {
		String url = productServiceBaseUrl+"/get/"+productId;
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class)	;
		return productDto;
		}

	public   CartItemDetailsDto  cartItemDetailsDto(CartItem cartItem, ProductDto productDto)
	{
		CartItemDetailsDto  cartItemDetailsDto = new  CartItemDetailsDto();
		cartItemDetailsDto.setProductId(cartItem.getProductId());
		cartItemDetailsDto.setProductName(productDto.getProductName());
		cartItemDetailsDto.setProductPrice(productDto.getProductPrice());
		return cartItemDetailsDto;
	}
}
