package  com.cg.productmgt.service;

import com.cg.productmgt.entities.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);
	
    List<Product> fetchAll();

    Product findById(String id);
}
