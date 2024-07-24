package com.travelcompany.eshop.data;

import com.travelcompany.eshop.exception.CustomerNotFoundException;
import com.travelcompany.eshop.exception.ItineraryNotFoundException;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.ui.CostBreakdown;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class OrderedTicketsImportData implements DataManagement {

    CostBreakdown costBreakdown = new CostBreakdown();
    List<Customer> loadedCustomers = loadDataFromFile(Finals.CUSTOMER_FILE_PATH, DataManagement::parseCustomer);
    List<Itinerary> itineraries = loadDataFromFile(Finals.ITINERARY_FILE_PATH, DataManagement::parseItinerary);

    public OrderedTicketsImportData() throws IOException, FileNotFoundException, ParseException {
        if (Files.notExists(Paths.get(Finals.ORDERED_TICKET_PATH))) {
            List<OrderedTicket> orderedTickets = new ArrayList<>();
            addToList(orderedTickets, 1, 1, 2, PaymentMethod.CASH);
            addToList(orderedTickets, 2, 2, 3, PaymentMethod.CASH);
            addToList(orderedTickets, 3, 3, 3, PaymentMethod.CREDIT_CARD);
            addToList(orderedTickets, 4, 2, 4, PaymentMethod.CREDIT_CARD);
            addToList(orderedTickets, 5, 3, 4, PaymentMethod.CASH);
            addToList(orderedTickets, 6, 4, 7, PaymentMethod.CREDIT_CARD);
            addToList(orderedTickets, 7, 5, 7, PaymentMethod.CREDIT_CARD);
            addToList(orderedTickets, 8, 2, 10, PaymentMethod.CASH);
            addToList(orderedTickets, 9, 1, 3, PaymentMethod.CASH);
            saveData(Finals.ORDERED_TICKET_PATH, orderedTickets);
        }
    }

    // included the wrong itinerary id input and handle it. 
    public void addToList(List<OrderedTicket> orderedTickets, int id, int customerId, int itineraryId, PaymentMethod paymentMethod) {
        Customer customer = null;
        Itinerary itinerary = null;
        try {
            if (customerId > 0 && customerId <= loadedCustomers.size()) {
                customer = loadedCustomers.get(customerId - 1);
            }
            if (customer == null) {
                throw new CustomerNotFoundException("Customer ID " + customerId + " wasn't found. Skipping this entry.");
            }
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (itineraryId > 0 && itineraryId <= itineraries.size()) {
                itinerary = itineraries.get(itineraryId - 1);
            }
            if (itinerary == null) {
                throw new ItineraryNotFoundException("Itinerary ID " + itineraryId + " wasn't found. Skipping this entry.");
            }
        } catch (ItineraryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        orderedTickets.add(new OrderedTicket(id, customerId, itineraryId, paymentMethod, costBreakdown.calculatingPayment(customer, itinerary, paymentMethod.getDiscount())));

    }

}
