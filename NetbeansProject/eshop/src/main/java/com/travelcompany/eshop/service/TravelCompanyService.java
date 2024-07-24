package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.ui.CostBreakdown;
import com.travelcompany.eshop.ui.DestinationChoosing;
import com.travelcompany.eshop.ui.OrderingTicket;
import com.travelcompany.eshop.ui.WelcomeScreen;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

public class TravelCompanyService {

    public TravelCompanyService() throws IOException, FileNotFoundException, ParseException {
        /*        3 classes for importing data. 
          We don't need them right now, so they became comments.
          You may uncomment and test them, but we will lose the additionally added Customers and OrderedTickets.
         */
//        new CustomerImportData();
//        new ItineraryImportData();
//        new OrderedTicketsImportData();    

        //Reporting Service is where i answer the questions in 6. Reporting.
        ReportingService reportingService = new ReportingService();
        //CostBreakdown is the class where i add all discounts(if any) and i return the final result.
        CostBreakdown costBreakdown = new CostBreakdown();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        //Making sure the user gives 1 or 2 or 0. if it gives string then another message is shown.
        while (choice != 0 & choice != 1 & choice != 2) {
            System.out.println("Welcome to TravelCompany. Please select : \n1. To view the Reports \n2. To view the Eshop \n0. To exit the application \n" + Finals.DELIMITER);
            while (!scanner.hasNextInt()) {
                System.out.println("Please insert a number...");
                scanner.next();
            }
            choice = scanner.nextInt();
        }
        switch (choice) {
            //If the user want to see the answers only...
            case 1:
                // I like Delimiters... it makes the console prettier in my eyes.
                System.out.println(Finals.DELIMITER);
                reportingService.firstQuestion();
                System.out.println(Finals.DELIMITER);
                reportingService.secondQuestion();
                System.out.println(Finals.DELIMITER);
                reportingService.thirdQuestion();
                System.out.println(Finals.DELIMITER);
                reportingService.fourthQuestion();
                break;
            //If the user wants to go in th Eshop..
            case 2:
                Customer customer = new WelcomeScreen().WelcomeScreen();
                Itinerary itinerary = new DestinationChoosing().chosenDestination();
                BigDecimal paymentdiscount = costBreakdown.paymentMethod();
                BigDecimal finalCost = costBreakdown.calculatingPayment(customer, itinerary, paymentdiscount);
                new OrderingTicket(customer,itinerary,finalCost,paymentdiscount);
                break;
            //If the user wants to leave.
            case 0:
                System.exit(choice);
            default:
                break;
        }
    }

}
