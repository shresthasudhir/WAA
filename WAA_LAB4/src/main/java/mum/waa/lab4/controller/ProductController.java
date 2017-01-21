package mum.waa.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.lab4.domain.Product;
import mum.waa.lab4.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping(value = "/products")
	public String getAllProducts(Model model) {

		model.addAttribute("products", productService.getAllProducts());
		return "products";

	}

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@RequestMapping(value = "/productList/{productId}", method = RequestMethod.GET)
	public String getProductList(@PathVariable("productId") String productId, Model model) {

		model.addAttribute("product", productService.getProductById(productId));
		return "productList";
	}

	@RequestMapping(value = "product/edit/{productId}", method = RequestMethod.GET)
	public String getEditProductPage(@PathVariable("productId") String productId, Model model) {

		model.addAttribute("editProduct", productService.getProductById(productId));
		return "editProduct";

	}

	@RequestMapping(value = "/product/edit/{productId}", method = RequestMethod.POST)
	public String processEditProductPage(@PathVariable("productId") String productId, Model model,
			@ModelAttribute("editProduct") Product editProduct, BindingResult result) {

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		boolean checkEdit = productService.editProduct(productId, editProduct);
		
		if(checkEdit){
			model.addAttribute("product", productService.getProductById(editProduct.getProductId()));
		}else{
			model.addAttribute("product", productService.getProductById(productId));
		}
		
		return "productList";
	}
	
	@RequestMapping(value = "product/delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") String productId, Model model) {

		boolean checkDelete = productService.deleteProduct(productId);
		
		if(checkDelete){
			return "redirect:/products";
		}else{
			model.addAttribute("editProduct", productService.getProductById(productId));
			return "editProduct";
			
		}
	}
	
}
