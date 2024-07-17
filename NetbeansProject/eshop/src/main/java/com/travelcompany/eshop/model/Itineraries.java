package com.travelcompany.eshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class Itineraries {

    private int id;
    private String departureAirportCode;
    private String destinationAirportCode;
    private Date departureDate;
    private String Airline;
    private BigDecimal price;

    public Itineraries(int id, String departureAirportCode, String destinationAirportCode, Date departureDate, String Airline, BigDecimal price) {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.Airline = Airline;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
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

    public void setAirline(String Airline) {
        this.Airline = Airline;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Itineraries{" + "id=" + id + ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode=" + destinationAirportCode + ", departureDate=" + departureDate + ", Airline=" + Airline + ", price=" + price + '}';
    }

}
