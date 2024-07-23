package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enums.PaymentMethod;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedTickets {
    private int id;
    private int customerId;
    private int itineraryId;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;

    @Override
    public String toString() {
        return "id=" + id + ", customerId=" + customerId + ", itineraryId=" + itineraryId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount;
    }
    

}
