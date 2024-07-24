package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class DestinationChoosing implements DataManagement<Itinerary> {

    public Itinerary chosenDestination() throws IOException, FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("These are your destinations : \n" + Finals.DELIMITER);
        List<Itinerary> itineraries = loadDataFromFile(Finals.ITINERARY_FILE_PATH, DataManagement::parseItinerary);
        Set<Itinerary> idSet = new HashSet<>();

        Set<String> countries = itineraries
                .stream()
                .map(Itinerary::getDestinationAirportCode)
                .map(s -> s.getName())
                .collect(Collectors.toSet());
        countries.forEach(System.out::println);
        boolean flag=true;
        while (flag) {
            System.out.println(Finals.DELIMITER + "\nPlease choose a destination: ");
            String destination = scanner.next();            
            if (countries.contains(destination)) {
                List<AirportCode> airportCode = itineraries
                        .stream()
                        .map(Itinerary::getDestinationAirportCode)
                        .filter(s -> s.getName().equals(destination))
                        .collect(Collectors.toList());
                for (Itinerary itinerary : itineraries) {
                    if (itinerary.getDestinationAirportCode().equals(airportCode.get(0))) {
                        if(itinerary.getNumberOfSeats()>0){
                             idSet.add(itinerary);
                                System.out.println("Id : " + itinerary.getId() + 
                                ", Date : " + itinerary.getDepartureDate() +
                                " Number of seats : "+itinerary.getNumberOfSeats()
                                + ", Price : " + itinerary.getPrice());
                                flag=false;
                        }
                        else
                        {
                            System.out.println("There are no seats, please choose another flight.");
                        }
                    }
                }
            }
        }
        while (true) {
            System.out.println(Finals.DELIMITER + "\nPlease choose the Id of your destination to reserve your tickets : ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Please choose a number for the Id : ");
            }
            int destID = scanner.nextInt();
            for (Itinerary itinerary : idSet) {
                if (itinerary.getId() == destID) {
                    itinerary.setNumberOfSeats(itinerary.getNumberOfSeats()-1);
                    itineraries.set(itinerary.getId()-1, itinerary);
                    saveData(Finals.ITINERARY_FILE_PATH, itineraries);
                    return itinerary;
                }
            }
        }
    }

}
