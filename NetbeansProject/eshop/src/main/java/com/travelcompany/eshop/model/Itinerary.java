package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.AirportCode;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Itinerary {

    private Integer id;
    private AirportCode departureAirportCode;
    private AirportCode destinationAirportCode;
    private String departureDate;
    private final String Airline = "SkyLines";
    private BigDecimal price;

    @Override
    public String toString() {
        return "id=" + id + ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode=" + destinationAirportCode + ", departureDate=" + departureDate + ", Airline=" + Airline + ", price=" + price;
    }
    


}
