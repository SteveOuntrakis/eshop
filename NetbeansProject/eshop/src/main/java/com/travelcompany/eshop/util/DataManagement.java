package com.travelcompany.eshop.util;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTickets;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.model.enums.CustomerCategory;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface DataManagement<T> {

    default void saveData(String outFilename, List<T> t) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outFilename)))) {
            for (T e : t) {
                pw.write(e.toString() + "\n");
            }
        }
    }

    default List<T> loadDataFromFile(String filename, Parser<T> parser) throws FileNotFoundException, IOException, ParseException {
        List<T> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(parser.parse(line));
            }
        }
        return list;
    }

    static Customer parseCustomer(String line) throws ParseException {
        String[] parts = line.split(", ");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        String name = parts[1].split("=")[1];
        String email = parts[2].split("=")[1];
        String address = parts[3].split("=")[1];
        String nationality = parts[4].split("=")[1];
        CustomerCategory category = CustomerCategory.valueOf(parts[5].split("=")[1]);
        return new Customer(id, name, email, address, nationality, category);
    }

    static Itinerary parseItinerary(String line) throws ParseException {
        String[] parts = line.split(", ");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        AirportCode departureCode = AirportCode.valueOf(parts[1].split("=")[1]);
        AirportCode destinationCode = AirportCode.valueOf(parts[2].split("=")[1]);
        String date = parts[3].split("=")[1];
        BigDecimal cost = new BigDecimal(parts[5].split("=")[1]);
        return new Itinerary(id, departureCode, destinationCode, date, cost);
    }

    static OrderedTickets parseOrderedTickets(String line) throws ParseException {
        String[] parts = line.split(", ");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        int customerId = Integer.parseInt(parts[1].split("=")[1]);
        int itineraryId = Integer.parseInt(parts[2].split("=")[1]);
        PaymentMethod paymentMethod = PaymentMethod.valueOf(parts[3].split("=")[1]);
        BigDecimal cost = new BigDecimal(parts[4].split("=")[1]);
        return new OrderedTickets(id, customerId, itineraryId, paymentMethod, cost);
    }
}
