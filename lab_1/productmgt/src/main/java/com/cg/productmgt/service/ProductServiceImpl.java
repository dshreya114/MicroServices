package  com.cg.productmgt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.productmgt.dao.IProductDao;
import com.cg.productmgt.entities.Product;

@Service
public class ProductServiceImpl implements IProductService {
	
    private IProductDao productDao;

    public IProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(IProductDao dao) {
        this.productDao = dao;
    }

    @Override
    public List<Product> fetchAll() {
        List<Product> products = productDao.fetchAll();
        return products;
    }

    @Override
    public Product findById(String id) {
        Product product=productDao.findById(id);
        return product;
    }

	@Override
	public Product save(Product product) {
	Product product1 = productDao.save(product);
	return product1;
	
	}
}
