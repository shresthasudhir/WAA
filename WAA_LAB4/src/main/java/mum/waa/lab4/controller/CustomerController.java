package mum.waa.lab4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.lab4.domain.Customer;
import mum.waa.lab4.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/customer")
	public String getAllProducts(Model model) {

		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";

	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("newCustomer", newCustomer);
		return "addCustomer";
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") @Valid Customer customer,BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			  return "addCustomer";
			}
		
		customerService.addCustomer(customer);
		model.addAttribute("customers",customerService.getAllCustomers() );
		return "customers";
	}

}
