package  com.cg.productmgt.entities;

import java.util.Objects;

public class Product {

    private String productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String id){
        this.productId=id;
    }

    private String productName;

    public String getProductName(){
        return productName;
    }

    public void setProductName(String name){
        this.productName=name;
    }

    private  double productPrice;
    
    public  double  getProductPrice(){
        return productPrice;
    }

    public void setProductPrice(double price){
        this.productPrice = price;
    }

    private  int   itemsCount;
   
	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product  product = (Product) obj;
	 return productId.equals(product.productId);
	}
    
    
}
