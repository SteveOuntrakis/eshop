package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public final class TicketService {

    Scanner scanner = new Scanner(System.in);

    public TicketService() throws IOException {
        welcomeScreen();
//        BigDecimal payment_method_discount = paymentMethod();
//        costBreakdown(customer, itineraries, payment_method_discount);
    }

    public void welcomeScreen() throws IOException {
        List<Customer> loadedCustomers = new DataManagementService<Customer>().loadDataFromFile("C:/Users/stef6/NetbeansProject/eshop/customers.txt", new Customer());
        System.out.println("Welcome to TravelCompany. Press 1 for validate, 2 for adding you in our system or 0 for exit :");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int login = scanner.nextInt();
        switch (login) {
            case 1:
                System.out.println("Please provide us the email for validation");
                String email = scanner.next();
                for (Customer cust : loadedCustomers) {
                    if (cust.getEmail().equals(email)) {
                        System.out.println("Hello " + cust.getName());
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
                System.out.println(lastId);
                System.out.println("Please add your details.. \nWhat is your name? :");
                String myName ;
                while (true) {
                    myName = scanner.next();

                    // Flag to determine if the name is valid
                    boolean isValid = true;

                    // Check if the name contains only letters
                    for (int i = 0; i < myName.length(); i++) {
                        if (!Character.isLetter(myName.charAt(i))) {
                            isValid = false;
                            break;
                        }
                    }

                    // If the name is valid, break the loop
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

    }

    public BigDecimal paymentMethod() {

        BigDecimal payment_method_discount = null;
        do {

            System.out.println("Please type 1 for Credit card, 2 for Cash or 0 for exit : ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int payment_method = scanner.nextInt();
            if (payment_method == 1 || payment_method == 2) {
                payment_method_discount = (PaymentMethod.CREDIT_CARD.getDiscount()).setScale(2, RoundingMode.HALF_UP);
                break;
            } else if (payment_method == 0) {
                System.exit(payment_method);
            }
        } while (true);
        return payment_method_discount;

    }

    public void costBreakdown(Customer customer, Itinerary itineraries, BigDecimal payment_method_discount) {
        var total_discount = payment_method_discount.add(customer.getCategory().getDiscount());
        var cost = itineraries.getPrice()
                .subtract(itineraries.getPrice()
                        .multiply(total_discount))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println(cost);
    }

}
