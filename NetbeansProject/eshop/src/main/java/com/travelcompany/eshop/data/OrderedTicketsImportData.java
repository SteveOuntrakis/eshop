package com.travelcompany.eshop.data;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.ui.CostBreakdown;
import com.travelcompany.eshop.util.DataManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class OrderedTicketsImportData implements DataManagement {

    CostBreakdown costBreakdown = new CostBreakdown();
    List<Customer> loadedCustomers = loadDataFromFile("customers.txt", DataManagement::parseCustomer);
    List<Itinerary> itineraries = loadDataFromFile("itineraries.txt", DataManagement::parseItinerary);

    public OrderedTicketsImportData() throws IOException, FileNotFoundException, ParseException {
        List<OrderedTickets> orderedTickets = new ArrayList<>();
        addToList(orderedTickets, 1, 0, 1, PaymentMethod.CASH);
        addToList(orderedTickets, 2, 1, 2, PaymentMethod.CASH);
        addToList(orderedTickets, 3, 2, 2, PaymentMethod.CREDIT_CARD);
        addToList(orderedTickets, 4, 1, 3, PaymentMethod.CREDIT_CARD);
        addToList(orderedTickets, 5, 2, 3, PaymentMethod.CASH);
        addToList(orderedTickets, 6, 3, 6, PaymentMethod.CREDIT_CARD);
        addToList(orderedTickets, 7, 4, 6, PaymentMethod.CREDIT_CARD);
        addToList(orderedTickets, 8, 1, 9, PaymentMethod.CASH);
        addToList(orderedTickets, 9, 0, 2, PaymentMethod.CASH);
        saveData("orderedTickets.txt", orderedTickets);
    }
    // included the wrong itinerary id input and handle it. 
    public void addToList(List<OrderedTickets> orderedTickets, int id, int customerId, int itineraryId, PaymentMethod paymentMethod) {
        try {
            Customer customer = loadedCustomers.get(customerId);
            Itinerary itinerary = itineraries.get(itineraryId);
            orderedTickets.add(new OrderedTickets(id, customerId, itineraryId, paymentMethod, costBreakdown.calculatingPayment(customer, itinerary, paymentMethod.getDiscount())));
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage() + " . The record wasn't added.");
        }

    }

}
