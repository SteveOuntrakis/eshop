package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.util.DataManagement;
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
        List<Customer> loadedCustomers = loadDataFromFile("customers.txt", new Customer());
        System.out.println("Welcome to TravelCompany. Press 1 for validate, 2 for adding you in our system or 0 for exit :");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int login = scanner.nextInt();
        switch (login) {
            case 1:
                Set<String> customerEmails = loadedCustomers
                        .stream()
                        .map(Customer::getEmail)
                        .collect(Collectors.toSet());
                while (true) {
                    System.out.println("Please provide us the email for validation");
                    String email = scanner.next();
                    if (customerEmails.contains(email)) {
                        for ( Customer customer : loadedCustomers){
                            if(customer.getEmail().equals(email))
                                return customer;
                        }
                        break;
                    }
                }
                break;
            case 2:
                int lastId = 0;
                for (Customer cust : loadedCustomers) {
                    lastId = cust.getId();
                }
                Customer customer = new Customer(lastId);
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
                    System.out.println("Your email should end with '@travelcompany.com'... ");
                    myEmail = scanner.next();
                }
                customer.setEmail(myEmail);
                System.out.println("Please add your address : ");
                customer.setAddress(scanner.next());
                System.out.println("Please add your nationality : ");
                customer.setNationality(scanner.next());
                break;
            case 0:
                System.exit(login);
            default:
                break;
        }
        return null;
    }

}
