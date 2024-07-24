package com.travelcompany.eshop.data;

import com.travelcompany.eshop.exception.AirportCodeException;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.AirportCode;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.travelcompany.eshop.util.DataManagement;
import com.travelcompany.eshop.util.Finals;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

public class ItineraryImportData implements DataManagement<Itinerary> {

    List<Itinerary> itineraries = new ArrayList<>();

    public ItineraryImportData() throws IOException, ParseException {
        if (Files.notExists(Paths.get(Finals.ITINERARY_FILE_PATH))) {

            addnewItinerary(1, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35", 250, new BigDecimal(300));
            addnewItinerary(2, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40", 250, new BigDecimal(420));
            addnewItinerary(3, AirportCode.ATH, AirportCode.AMS, "22/02/2022 13:45", 250, new BigDecimal(280));
            addnewItinerary(4, AirportCode.ATH, AirportCode.PAR, "22/02/2022 14:20", 250, new BigDecimal(310));
            addnewItinerary(5, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:35", 250, new BigDecimal(880));
            addnewItinerary(6, AirportCode.ATH, AirportCode.FRA, "22/02/2022 14:55", 250, new BigDecimal(380));
            addnewItinerary(7, AirportCode.ATH, AirportCode.FRA, "22/02/2022 15:35", 250, new BigDecimal(350));
            addnewItinerary(8, AirportCode.ATH, AirportCode.MEX, "22/02/2022 16:00", 250, new BigDecimal(1020));
            addnewItinerary(9, AirportCode.ATH, AirportCode.DUB, "22/02/2022 16:35", 250, new BigDecimal(770));
            saveData(Finals.ITINERARY_FILE_PATH, itineraries);
        }
    }

    private void addnewItinerary(int id, AirportCode depAirportCode, AirportCode destAirpotCode, String date, int seats, BigDecimal cost) {
        try{
            if (depAirportCode==null||destAirpotCode==null)
            {
                throw new AirportCodeException("The AirportCode wasn't found!!");
            }
            itineraries.add(new Itinerary(id, depAirportCode, destAirpotCode, date, seats, cost));
        }
        catch(AirportCodeException e){
            System.out.println(e.getMessage());
        }
            
    }
}
