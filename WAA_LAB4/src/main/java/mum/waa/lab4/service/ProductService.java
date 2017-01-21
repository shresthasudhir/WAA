package mum.waa.lab4.service;

import java.util.List;

import mum.waa.lab4.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(String productId);
	void addProduct(Product product);
	boolean editProduct(String editProductId, Product product);
	boolean deleteProduct(String productId);
}
