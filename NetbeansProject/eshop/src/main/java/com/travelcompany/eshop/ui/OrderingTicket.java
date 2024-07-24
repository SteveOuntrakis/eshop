package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.util.DataManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

public class OrderingTicket implements DataManagement{

    public OrderingTicket(Customer customer, Itinerary itinerary, BigDecimal finalCost,BigDecimal paymentDiscount) throws IOException, FileNotFoundException, ParseException {
        List<OrderedTickets> orderedTickets = loadDataFromFile("orderedTickets.txt", DataManagement::parseOrderedTickets);
        int nextID= (orderedTickets.stream().map(OrderedTickets::getId).max(Integer::compareTo).orElse(0))+1;
        PaymentMethod paymentMethod;
        if (paymentDiscount == new BigDecimal(BigInteger.ZERO)){
            paymentMethod = PaymentMethod.CASH;
        }
        else{
            paymentMethod = PaymentMethod.CREDIT_CARD;
        }
        OrderedTickets orderedTicket = new OrderedTickets(nextID,customer.getId(),itinerary.getId(),paymentMethod,finalCost);
        orderedTickets.add(orderedTicket);
        saveData("orderedTickets.txt", orderedTickets);
    }

}
