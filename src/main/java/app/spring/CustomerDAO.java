package app.spring;

import app.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
