package  com.cg.productmgt.dao;

import java.util.List;
import  com.cg.productmgt.entities.Product;

public interface IProductDao {

	Product  save(Product product);
	
    List<Product>fetchAll();

    Product findById(String id);

}
