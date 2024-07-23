package com.travelcompany.eshop.data;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.enums.CustomerCategory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.travelcompany.eshop.util.DataManagement;

public class CustomerImportData implements DataManagement<Customer> {

    public CustomerImportData() throws IOException, Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(3, "Ioannis Ioannou", "iioanou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customers.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        customers.add(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS));
        customers.add(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL));
        saveData("customers.txt", customers);
    }
}
