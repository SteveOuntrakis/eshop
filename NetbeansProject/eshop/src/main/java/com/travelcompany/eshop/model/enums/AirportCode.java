package com.travelcompany.eshop.model.enums;

public enum AirportCode {
    ATH("Athens"),
    PAR("Paris"),
    LON("London"),
    AMS("Amsterdam"),
    DUB("Dublin"),
    FRA("Frankfurt"),
    MEX("Mexico");
    private String name;

    private AirportCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
