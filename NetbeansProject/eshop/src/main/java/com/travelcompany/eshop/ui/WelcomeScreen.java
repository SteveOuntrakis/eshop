package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.exception.InvalidEmailException;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.enums.CustomerCategory;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class WelcomeScreen implements DataManagement<Customer> {

    Scanner scanner = new Scanner(System.in);

    public Customer WelcomeScreen() throws IOException, FileNotFoundException, ParseException {
        List<Customer> customers = loadDataFromFile(Finals.CUSTOMER_FILE_PATH, DataManagement::parseCustomer);
        int login = -1;
        while (login != 0 & login != 1 & login != 2) {
            System.out.println(Finals.DELIMITER + "\nPress 1 for validate, 2 for adding you in our system or 0 for exit :");
            while (!scanner.hasNextInt()) {
                System.out.println("Please insert a number...");
                scanner.next();
            }
            login = scanner.nextInt();
        }
        switch (login) {
            case 1:
                return validateUser(customers);
            case 2:
                return insertCustomer(customers);
            case 0:
                System.exit(login);
            default:
                break;
        }
        return null;
    }

    private Customer validateUser(List<Customer> loadedCustomers) {
        Set<String> customerEmails = loadedCustomers
                .stream()
                .map(Customer::getEmail)
                .collect(Collectors.toSet());
        while (true) {
            String email = scanner.nextLine();
            System.out.println(Finals.DELIMITER + "\nPlease provide us the email for validation or press 0 for exit.");
            if (customerEmails.contains(email)) {
                for (Customer customer : loadedCustomers) {
                    if (customer.getEmail().equals(email)) {
                        System.out.println(Finals.DELIMITER + "\nHello " + customer.getName());
                        return customer;
                    }
                }
                break;
            } else if (email.equals("0")) {
                System.exit(Integer.parseInt(email));
            }
        }
        return null;
    }

    private Customer insertCustomer(List<Customer> customers) throws IOException {
        int lastId = 0;
        for (Customer cust : customers) {
            lastId = cust.getId();
        }
        Customer customer = new Customer(lastId + 1);
        System.out.println("Please add your details.. \nWhat is your name? :");
        String myName;
        while (true) {
            myName = scanner.next();
            boolean isValid = true;
            for (int i = 0; i < myName.length(); i++) {
                if (!Character.isLetter(myName.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                break;
            } else {
                System.out.println("Invalid name. Please insert characters only...");
            }
        }
        customer.setName(myName);
        System.out.println("Please insert your email: ");
        String myEmail = scanner.next();
        while (!myEmail.endsWith("@travelcompany.com")) {
            try {
                myEmail = scanner.nextLine();
                throw new InvalidEmailException("Your email should end with '@travelcompany.com'... ");
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            }
        }
        customer.setEmail(myEmail);
        System.out.println("Please add your address : ");
        customer.setAddress(scanner.next());
        System.out.println("Please add your nationality : ");
        customer.setNationality(scanner.next());
        customer.setCategory(CustomerCategory.INDIVIDUAL);
        customers.add(customer);
        saveData(Finals.CUSTOMER_FILE_PATH, customers);
        return customer;
    }
}
