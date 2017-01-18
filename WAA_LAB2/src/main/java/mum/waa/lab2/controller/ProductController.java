package mum.waa.lab2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.waa.lab2.repository.ProductRepository;


@Controller
public class ProductController {
	
	@Autowired
	ProductRepository inMemoryRepo;
	
	@RequestMapping(value="/products")
	public String getAllProducts(Model model){
        
		model.addAttribute("products", inMemoryRepo.getAllProducts());
		return "products";
		
	}
	
	@RequestMapping(value = "/productList/{productId}", method = RequestMethod.GET)
	public String getProductList(@PathVariable("productId") String productId, Model model){

		model.addAttribute("product", inMemoryRepo.getProductById(productId));
		return "productList";
	}
}
