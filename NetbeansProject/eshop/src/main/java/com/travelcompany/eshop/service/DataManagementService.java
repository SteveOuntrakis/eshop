package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.model.enums.CustomerCategory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataManagementService<T> {

    public void saveData(String outFilename, List<T> t) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outFilename)));
        for (T e : t) {
            pw.write(e.toString() + "\n");
        }
        pw.close();
    }

    public List<T> loadDataFromFile(String filename,T t) throws FileNotFoundException, IOException {
        List<T> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
           if (t instanceof Customer){
               list.add((T) parseCustomer(line));
           }
           else if (t instanceof  Itinerary){
               list.add((T) parseItinerary(line));
           } 
        }
        return list;
    }

    private Customer parseCustomer(String line) {
        String[] parts = line.split(", ");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        String name = parts[1].split("=")[1];
        String email = parts[2].split("=")[1];
        String address = parts[3].split("=")[1];
        String nationality = parts[4].split("=")[1];
        CustomerCategory category = CustomerCategory.valueOf(parts[5].split("=")[1]);
        return new Customer(id, name, email, address, nationality, category);
    }

    private Itinerary parseItinerary(String line) {
        String[] parts = line.split(", ");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        AirportCode departureCode = AirportCode.valueOf(parts[1].split("=")[1]);
        AirportCode destinationCode = AirportCode.valueOf(parts[2].split("=")[1]);
        //Date date = (parts[3].split("=")[1]);
        //String airline = parts[4].split("=")[1];
        BigDecimal cost = new BigDecimal(parts[5].split("=")[1]);
        return new Itinerary(id, departureCode, destinationCode, cost);
    }
}
