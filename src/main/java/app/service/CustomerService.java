package app.service;

import app.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCostumer(int id);

    void deleteCustomer(int id);

    List<Customer> getCustomersBySearch(String theSearchName);
}
