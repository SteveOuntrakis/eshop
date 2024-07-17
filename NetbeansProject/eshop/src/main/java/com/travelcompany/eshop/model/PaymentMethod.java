package com.travelcompany.eshop.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public enum PaymentMethod {
    CASH(new BigDecimal(BigInteger.ZERO)),
    CREDIT_CARD(new BigDecimal(0.1));

    private final BigDecimal discount;

    private PaymentMethod(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

}
