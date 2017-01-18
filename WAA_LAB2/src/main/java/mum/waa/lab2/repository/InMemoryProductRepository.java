package mum.waa.lab2.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mum.waa.lab2.model.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository {
	
	private final List<Product> listOfProduct;
	
	public InMemoryProductRepository() { 
		listOfProduct = new ArrayList<>();
		
		Product iPhone = new Product();
		
		iPhone.setName("IPhone 5S");
		iPhone.setProductId("IP123");
		
		Long l = new Long(500);
		iPhone.setUnitPrice(BigDecimal.valueOf(l));
		iPhone.setUnitsInStock(150);
		iPhone.setDescription("New IPhone 5S released on Nov 22, 2011.");
		iPhone.setManufacturer("Apple");
		iPhone.setCategory("Phone Gadget");
		iPhone.setCondition("New");
					
		Product iPad = new Product();
		
        iPad.setName("IPad 3");
        iPad.setProductId("ipad1234");
        Long l2 = new Long(700);
		iPad.setUnitPrice(BigDecimal.valueOf(l2));
        iPad.setUnitsInStock(100);
        iPad.setDescription("New IPad 3 released on Jan 14, 2012.");
        iPad.setManufacturer("Apple");
        iPad.setCategory("Pad Gadget");
        iPad.setCondition("Refurnished");
        
   
        listOfProduct.add(iPhone);
        listOfProduct.add(iPad);
	       
	}
	
	@Override
	public List<Product> getAllProducts() {
		return listOfProduct;
	}
	
	@Override
	public Product getProductById(String productId){
		Product p = null;
		for(int i = 0; i < listOfProduct.size(); i++){
			if(listOfProduct.get(i).getProductId().equals(productId)){
				p = listOfProduct.get(i);
			}
		}
		return p;
	}
}