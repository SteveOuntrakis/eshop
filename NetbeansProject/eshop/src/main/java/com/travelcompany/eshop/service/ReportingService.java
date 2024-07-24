package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.util.DataManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportingService implements DataManagement {

    private List<Customer> customers;
    private List<OrderedTickets> orderedTickets;
    private List<Itinerary> itineraries;

    public ReportingService() throws IOException, FileNotFoundException, ParseException {
        customers = loadDataFromFile("customers.txt", DataManagement::parseCustomer);
        orderedTickets = loadDataFromFile("orderedTickets.txt", DataManagement::parseOrderedTickets);
        itineraries = loadDataFromFile("itineraries.txt", DataManagement::parseItinerary);
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
                    .map(OrderedTickets::getPaymentAmount)
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
        Customer maxTicketsCustomer = null;
        int maxTickets = 0;

        Customer maxCostCustomer = null;
        BigDecimal maxCost = BigDecimal.ZERO;

        for (Customer customer : customers) {
            int ticketCount = (int) orderedTickets.stream()
                    .filter(ticket -> ticket.getCustomerId() == customer.getId())
                    .count();

            BigDecimal totalCost = orderedTickets.stream()
                    .filter(ticket -> ticket.getCustomerId() == customer.getId())
                    .map(OrderedTickets::getPaymentAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            if (ticketCount > maxTickets) {
                maxTickets = ticketCount;
                maxTicketsCustomer = customer;
            }

            if (totalCost.compareTo(maxCost) > 0) {
                maxCost = totalCost;
                maxCostCustomer = customer;
            }
        }

        System.out.println("Customer with the most tickets: " + (maxTicketsCustomer != null ? maxTicketsCustomer.getName() + " (" + maxTickets + " tickets)" : "None"));
        System.out.println("Customer with the largest cost of purchases: " + (maxCostCustomer != null ? maxCostCustomer.getName() + " (" + maxCost + ")" : "None"));
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
