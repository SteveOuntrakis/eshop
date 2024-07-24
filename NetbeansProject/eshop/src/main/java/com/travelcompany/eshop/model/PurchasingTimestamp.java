package com.travelcompany.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasingTimestamp {

    private int customerId;
    private int itineraryId;
    private String departureDate;
    private String purchasingDate;

    @Override
    public String toString() {
        return "customer=" + customerId + ", itinerary=" + itineraryId + ", departureDate=" + departureDate + ", purchasingDate=" + purchasingDate;
    }

}
