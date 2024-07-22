package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.AirportCode;
import java.math.BigDecimal;
import java.util.Date;

public class Itinerary {

    private Integer id;
    private AirportCode departureAirportCode;
    private AirportCode destinationAirportCode;
    private Date departureDate;
    private final String Airline = "SkyLines";
    private BigDecimal price;

    public Itinerary() {
    }

    public Itinerary(Integer id, AirportCode departureAirportCode, AirportCode destinationAirportCode, BigDecimal price) {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.price = price;
    }
    

    public Itinerary(Integer id, AirportCode departureAirportCode, AirportCode destinationAirportCode, Date departureDate, BigDecimal price) {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AirportCode getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(AirportCode departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public AirportCode getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(AirportCode destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirline() {
        return Airline;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id + ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode=" + destinationAirportCode + ", departureDate=" + departureDate + ", Airline=" + Airline + ", price=" + price;
    }
    


}
