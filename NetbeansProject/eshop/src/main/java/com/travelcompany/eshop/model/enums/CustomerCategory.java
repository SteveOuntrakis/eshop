package com.travelcompany.eshop.model.enums;

import java.math.BigDecimal;

public enum CustomerCategory {
    BUSINESS(new BigDecimal(0.1)),
    INDIVIDUAL(new BigDecimal(-0.2));

    private final BigDecimal discount;

    private CustomerCategory(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

}
