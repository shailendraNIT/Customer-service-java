package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(UUID.randomUUID().toString());
		return customerDao.save(customer);
	}

	@Override
	public List<Customer> displayCustomersList() {
		return customerDao.findAll();
	}

}
