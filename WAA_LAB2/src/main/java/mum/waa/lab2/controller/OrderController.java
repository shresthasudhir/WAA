package mum.waa.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.waa.lab2.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/order/{productId}/{count}")
	public String processOrder(@PathVariable String productId,@PathVariable("count") int quantity){
		orderService.processOrder(productId, quantity);
		return "redirect:/products";
	}

}
