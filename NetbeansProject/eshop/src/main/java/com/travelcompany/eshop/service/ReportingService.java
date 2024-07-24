package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportingService implements DataManagement {

    private List<Customer> customers;
    private List<OrderedTicket> orderedTickets;
    private List<Itinerary> itineraries;

    public ReportingService() throws IOException, FileNotFoundException, ParseException {
        customers = loadDataFromFile(Finals.CUSTOMER_FILE_PATH, DataManagement::parseCustomer);
        orderedTickets = loadDataFromFile(Finals.ORDERED_TICKET_PATH, DataManagement::parseOrderedTickets);
        itineraries = loadDataFromFile(Finals.ITINERARY_FILE_PATH, DataManagement::parseItinerary);
    }

    public void firstQuestion() {
        System.out.println("List of the total number and list of the cost of tickets for all customers");
        List<String> customerNames = new ArrayList<>();
        List<Integer> totalTicketsList = new ArrayList<>();
        List<BigDecimal> totalCostList = new ArrayList<>();

        for (Customer customer : customers) {
            customerNames.add(customer.getName());

            int ticketCount = (int) orderedTickets.stream()
                    .filter(ticket -> ticket.getCustomerId() == customer.getId())
                    .count();

            BigDecimal totalCost = orderedTickets.stream()
                    .filter(ticket -> ticket.getCustomerId() == customer.getId())
                    .map(OrderedTicket::getPaymentAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            totalTicketsList.add(ticketCount);
            totalCostList.add(totalCost);
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Customer: " + customerNames.get(i)
                    + ", Total Tickets: " + totalTicketsList.get(i)
                    + ", Total Cost: " + totalCostList.get(i));
        }
    }

    public void secondQuestion() {
        System.out.println("List of the total offered itineraries per destination and offered itineraries per departure");
        List<AirportCode> destinationAirports = itineraries.stream()
                .map(Itinerary::getDestinationAirportCode)
                .distinct()
                .collect(Collectors.toList());

        List<AirportCode> departureAirports = itineraries.stream()
                .map(Itinerary::getDepartureAirportCode)
                .distinct()
                .collect(Collectors.toList());

        List<Integer> itinerariesPerDestination = new ArrayList<>();
        for (AirportCode destination : destinationAirports) {
            int count = (int) itineraries.stream()
                    .filter(itinerary -> itinerary.getDestinationAirportCode().equals(destination))
                    .count();
            itinerariesPerDestination.add(count);
        }

        List<Integer> itinerariesPerDeparture = new ArrayList<>();
        for (AirportCode departure : departureAirports) {
            int count = (int) itineraries.stream()
                    .filter(itinerary -> itinerary.getDepartureAirportCode().equals(departure))
                    .count();
            itinerariesPerDeparture.add(count);
        }

        System.out.println("Total offered itineraries per destination:");
        for (int i = 0; i < destinationAirports.size(); i++) {
            System.out.println("Destination: " + destinationAirports.get(i) + ", Count: " + itinerariesPerDestination.get(i));
        }

        System.out.println("\nTotal offered itineraries per departure:");
        for (int i = 0; i < departureAirports.size(); i++) {
            System.out.println("Departure: " + departureAirports.get(i) + ", Count: " + itinerariesPerDeparture.get(i));
        }
    }

    public void thirdQuestion() {
        System.out.println("List of the customers with the most tickets and with the largest cost of purchases ");
        List<Customer> maxTicketsCustomers = new ArrayList<>();
        List<Customer> maxCostCustomers = new ArrayList<>();
        int maxTickets = 0;
        BigDecimal maxCost = BigDecimal.ZERO;

        for (Customer customer : customers) {
            int ticketCount = 0;
            BigDecimal totalCost = BigDecimal.ZERO;

            for (OrderedTicket ticket : orderedTickets) {
                if (ticket.getCustomerId() == customer.getId()) {
                    ticketCount++;
                    totalCost = totalCost.add(ticket.getPaymentAmount());
                }
            }

            if (ticketCount > maxTickets) {
                maxTickets = ticketCount;
                maxTicketsCustomers= new ArrayList<>();
                maxTicketsCustomers.add(customer);
            } else if (ticketCount == maxTickets) {
                maxTicketsCustomers.add(customer);
            }

            if (totalCost.compareTo(maxCost) > 0) {
                maxCost = totalCost;
                maxCostCustomers.clear();
                maxCostCustomers.add(customer);
            } else if (totalCost.compareTo(maxCost) == 0) {
                maxCostCustomers.add(customer);
            }
        }
        System.out.println("Customers with the most tickets (" + maxTickets + " tickets):");
        for (Customer customer : maxTicketsCustomers) {
            System.out.println(" - " + customer.getName());
        }
        System.out.println("Customers with the largest cost of purchases (" + maxCost + "):");
        for (Customer customer : maxCostCustomers) {
            System.out.println(" - " + customer.getName());
        }
    }

    public void fourthQuestion() {
        System.out.println("List of the customers who have not purchased any tickets");

        List<Customer> customerWithoutTickets = customers
                .stream()
                .filter(c -> orderedTickets.stream().noneMatch(t -> t.getCustomerId() == c.getId()))
                .collect(Collectors.toList());
        customerWithoutTickets.forEach(c -> System.out.println(c.getName()));

    }

}
