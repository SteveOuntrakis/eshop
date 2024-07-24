package com.travelcompany.eshop.util;

import java.text.ParseException;

//An interface created firstly to include a FunctionalInterface in the code, and secondly to help me manage the DataManagement util class.
//It is used in the loadDataFromFile in order to define which method should i use next.. ParseCustomer, ParseItinerary or ParseOrderedTicket.
@FunctionalInterface
public interface Parser<T> {
    T parse(String line) throws ParseException;
}
