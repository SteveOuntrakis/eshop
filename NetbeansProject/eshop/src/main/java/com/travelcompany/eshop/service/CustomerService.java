package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.CustomerCategory;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public CustomerService() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(2, "Dimitriou Dimitrios", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(3, "Ioannis Ioannou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(4, "Antonio Molinari", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(5, "Frederico Rossi", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(6, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(7, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(8, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(9, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
    }

}
