package mum.waa.lab4.repository;

import java.util.List;

import mum.waa.lab4.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(String productId);
}
