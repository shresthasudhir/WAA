package mum.waa.lab4.service;

import java.util.List;

import mum.waa.lab4.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void addCustomer(Customer customer);
}
