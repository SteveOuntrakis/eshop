package com.travelcompany.eshop;

import com.travelcompany.eshop.data.CustomerImportData;
import com.travelcompany.eshop.data.ItineraryImportData;
import com.travelcompany.eshop.data.OrderedTicketsImportData;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.service.ReportingService;
import com.travelcompany.eshop.ui.CostBreakdown;
import com.travelcompany.eshop.ui.DestinationChoosing;
import com.travelcompany.eshop.ui.WelcomeScreen;
import java.io.IOException;
import java.math.BigDecimal;

public class Eshop {

    public static void main(String[] args) throws IOException, Exception{
        new CustomerImportData();
        new ItineraryImportData();
        new OrderedTicketsImportData();
        ReportingService reportingService = new ReportingService();
        System.out.println("--------------------------------------------------------------");
        reportingService.firstQuestion();
        System.out.println("--------------------------------------------------------------");
        reportingService.secondQuestion();
//        CostBreakdown costBreakdown = new CostBreakdown();
//        Customer customer = new WelcomeScreen().WelcomeScreen();
//        Itinerary itinerary =  new DestinationChoosing().chosenDestination();
//        BigDecimal paymentdiscount = costBreakdown.paymentMethod();
//        costBreakdown.calculatingPayment(customer, itinerary, paymentdiscount);
    }
}
