package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.enums.CustomerCategory;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {

    public CustomerService() throws IOException, Exception {
        
        List<Customer> customers = new ArrayList<>();
        List<Itinerary> itineraries = new ArrayList<>();
        
        itineraries.add(new Itinerary(1, AirportCode.ATH, AirportCode.PAR, new Date(), new BigDecimal(300)));
        itineraries.add(new Itinerary(2, AirportCode.ATH, AirportCode.LON, new Date(), new BigDecimal(420)));
        itineraries.add(new Itinerary(3, AirportCode.ATH, AirportCode.AMS, new Date(), new BigDecimal(280)));
        itineraries.add(new Itinerary(4, AirportCode.ATH, AirportCode.PAR, new Date(), new BigDecimal(310)));
        itineraries.add(new Itinerary(5, AirportCode.ATH, AirportCode.DUB, new Date(), new BigDecimal(880)));
        itineraries.add(new Itinerary(6, AirportCode.ATH, AirportCode.FRA, new Date(), new BigDecimal(380)));
        itineraries.add(new Itinerary(7, AirportCode.ATH, AirportCode.FRA, new Date(), new BigDecimal(350)));
        itineraries.add(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, new Date(), new BigDecimal(1020)));
        itineraries.add(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, new Date(), new BigDecimal(770)));
        customers.add(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(3, "Ioannis Ioannou", "iioanou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customers.add(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        customers.add(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS));
        customers.add(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL));
        new DataManagementService<Customer>().saveData("C:/Users/stef6/NetbeansProject/eshop/customers.txt",customers);
        new DataManagementService<Itinerary>().saveData("C:/Users/stef6/NetbeansProject/eshop/itineraries.txt", itineraries);
//        List<Customer> loadedCustomers = new DataManagementService<Customer>().loadDataFromFile("C:/Users/stef6/NetbeansProject/eshop/customers.txt",new Customer());
//        List<Itinerary> loadedItineraries = new DataManagementService<Itinerary>().loadDataFromFile("C:/Users/stef6/NetbeansProject/eshop/itineraries.txt",new Itinerary());
//        for (Customer cust : loadedCustomers) {
//            System.out.println(cust);
//            System.out.println(cust.getEmail());
//        }  
//        for (Itinerary itinerary : loadedItineraries) {
//            System.out.println(itinerary);
//            System.out.println(itinerary.getPrice());
//        }

    }

    

}
