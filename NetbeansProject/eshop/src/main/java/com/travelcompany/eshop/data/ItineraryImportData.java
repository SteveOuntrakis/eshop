package com.travelcompany.eshop.data;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.travelcompany.eshop.util.DataManagement;
import java.text.ParseException;

public class ItineraryImportData implements DataManagement<Itinerary> {

    public ItineraryImportData() throws IOException, ParseException {
        List<Itinerary> itineraries = new ArrayList<>();
        itineraries.add(new Itinerary(1, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35", new BigDecimal(300)));
        itineraries.add(new Itinerary(2, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40", new BigDecimal(420)));
        itineraries.add(new Itinerary(3, AirportCode.ATH, AirportCode.AMS, "22/02/2022 13:45", new BigDecimal(280)));
        itineraries.add(new Itinerary(4, AirportCode.ATH, AirportCode.PAR, "22/02/2022 14:20", new BigDecimal(310)));
        itineraries.add(new Itinerary(5, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:35", new BigDecimal(880)));
        itineraries.add(new Itinerary(6, AirportCode.ATH, AirportCode.FRA, "22/02/2022 14:55", new BigDecimal(380)));
        itineraries.add(new Itinerary(7, AirportCode.ATH, AirportCode.FRA, "22/02/2022 15:35", new BigDecimal(350)));
        itineraries.add(new Itinerary(8, AirportCode.ATH, AirportCode.MEX, "22/02/2022 16:00", new BigDecimal(1020)));
        itineraries.add(new Itinerary(9, AirportCode.ATH, AirportCode.DUB, "22/02/2022 16:35", new BigDecimal(770)));
        saveData("itineraries.txt", itineraries);
    }
}
