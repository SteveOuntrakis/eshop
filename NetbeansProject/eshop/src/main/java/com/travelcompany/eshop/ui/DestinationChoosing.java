package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.util.DataManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DestinationChoosing implements DataManagement<Itinerary> {

    Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER ="-------------------------------------";
    
    public Itinerary chosenDestination () throws IOException, FileNotFoundException, ParseException{
        System.out.println("These are your destinations : \n" +DELIMITER);
        List<Itinerary> itineraries = loadDataFromFile("itineraries.txt",DataManagement:: parseItinerary);
        Set<Itinerary> idSet = new HashSet<>();

        Set<String> countries = itineraries
                .stream()
                .map(Itinerary::getDestinationAirportCode)
                .map(s -> s.getName())
                .collect(Collectors.toSet());
        countries.forEach(System.out::println);
        while (true) {
            System.out.println( DELIMITER+ "\nPlease choose a destination: ");
            String destination = scanner.next();
            if (countries.contains(destination)) {
                List<AirportCode> airportCode = itineraries
                        .stream()
                        .map(Itinerary::getDestinationAirportCode)
                        .filter(s -> s.getName().equals(destination))
                        .collect(Collectors.toList());
                for (Itinerary itinerary : itineraries) {
                    if (itinerary.getDestinationAirportCode().equals(airportCode.get(0))) {
                        idSet.add(itinerary);
                        System.out.println("Id : " + itinerary.getId() + ", Date : " + itinerary.getDepartureDate() + ", Price : " + itinerary.getPrice());
                    }
                }
                break;
            }
        }
        while (true) {
            System.out.println(DELIMITER+"\nPlease choose the Id of your destination to reserve your tickets : ");
            while (!scanner.hasNextInt()) {  
                scanner.next();
                System.out.println("Please choose a number for the Id : ");                
            }
            int destID = scanner.nextInt();
            System.out.println(idSet.toString());
            for (Itinerary itinerary : idSet) {
                if (itinerary.getId() == destID) {                    
                    return itinerary;
                }
            }
        }
    }

}
