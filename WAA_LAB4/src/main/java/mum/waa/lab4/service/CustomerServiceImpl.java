package mum.waa.lab4.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import mum.waa.lab4.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final List<Customer> listOfCustomer;

	public CustomerServiceImpl() {
		listOfCustomer = new ArrayList<>();

		Customer customer1 = new Customer();

		customer1.setUsername("Sudhir Shrestha");
		customer1.setAddress("Fairfield, IA");
		// customer1.setDateOfBirth(LocalDate.of(1990, 10, 25));
		customer1.setDateOfBirth(new Date(20/01/2016));
		customer1.setPassword("sudhir123");
		customer1.setSex("Male");

		listOfCustomer.add(customer1);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return listOfCustomer;
	}

	@Override
	public void addCustomer(Customer newCustomer) {
		listOfCustomer.add(newCustomer);
	}
}
