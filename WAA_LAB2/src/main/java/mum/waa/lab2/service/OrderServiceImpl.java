package mum.waa.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.lab2.model.Product;
import mum.waa.lab2.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void processOrder(String productId, int quantity){
		Product orderProduct = productRepository.getProductById(productId);
		
		if(orderProduct != null){
			if(quantity < orderProduct.getUnitsInStock()){
				orderProduct.setUnitsInStock(orderProduct.getUnitsInStock() - quantity);
			}else{
				throw new IllegalArgumentException("Something Went Wrong");
			}
		}
	}
}
