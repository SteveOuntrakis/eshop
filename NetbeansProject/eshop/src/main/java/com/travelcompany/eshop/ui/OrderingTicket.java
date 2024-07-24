package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.model.PurchasingTimestamp;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderingTicket implements DataManagement {

    public OrderingTicket(Customer customer, Itinerary itinerary, BigDecimal finalCost, BigDecimal paymentDiscount) throws IOException, FileNotFoundException, ParseException {
        List<OrderedTicket> orderedTickets = loadDataFromFile(Finals.ORDERED_TICKET_PATH, DataManagement::parseOrderedTickets);

        int nextID = (orderedTickets.stream().map(OrderedTicket::getId).max(Integer::compareTo).orElse(0)) + 1;
        PaymentMethod paymentMethod;
        if (paymentDiscount == new BigDecimal(BigInteger.ZERO)) {
            paymentMethod = PaymentMethod.CASH;
        } else {
            paymentMethod = PaymentMethod.CREDIT_CARD;
        }
        /*
        start of 7.1:
        Additional Functionalities: 
        Store the transactions of the customers when buying tickets with timestamps for the date and time of the purchases.
         */
        List<PurchasingTimestamp> timestamps;
        if (Files.notExists(Paths.get(Finals.PURCHASING_TIMESTAMP))) {
            timestamps = new ArrayList<>();
        } else {
            timestamps = loadDataFromFile(Finals.PURCHASING_TIMESTAMP, DataManagement::parsePurchasingTimestamp);
        }
        String currentDate = LocalDate.now().toString();
        timestamps.add(new PurchasingTimestamp(customer.getId(),itinerary.getId(),itinerary.getDepartureDate(), currentDate));
        saveData(Finals.PURCHASING_TIMESTAMP, timestamps);
        //End of 7.1

        OrderedTicket orderedTicket = new OrderedTicket(nextID, customer.getId(), itinerary.getId(), paymentMethod, finalCost);
        orderedTickets.add(orderedTicket);
        saveData(Finals.ORDERED_TICKET_PATH, orderedTickets);
    }

}
