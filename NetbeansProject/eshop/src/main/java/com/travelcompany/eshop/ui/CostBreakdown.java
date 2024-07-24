package com.travelcompany.eshop.ui;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.enums.PaymentMethod;
import com.travelcompany.eshop.util.Finals;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CostBreakdown {

    public BigDecimal paymentMethod() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal payment_method_discount = null;
        OUTER:
        do {
            System.out.println(Finals.DELIMITER + "\nFor your Payment, please type 1 for Credit card, 2 for Cash or 0 for exit : ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int payment_method = scanner.nextInt();
            switch (payment_method) {
                case 1:
                    payment_method_discount = (PaymentMethod.CREDIT_CARD.getDiscount()).setScale(2, RoundingMode.HALF_UP);
                    break OUTER;
                case 2:
                    payment_method_discount = (PaymentMethod.CASH.getDiscount()).setScale(2, RoundingMode.HALF_UP);
                    break OUTER;
                case 0:
                    System.exit(payment_method);
                default:
                    break;
            }
        } while (true);
        return payment_method_discount;
    }

    public BigDecimal calculatingPayment(Customer customer, Itinerary itineraries, BigDecimal payment_method_discount) {
        var total_discount = payment_method_discount.add(customer.getCategory().getDiscount());
        var cost = itineraries.getPrice()
                .subtract(itineraries.getPrice()
                        .multiply(total_discount))
                .setScale(2, RoundingMode.HALF_UP);        
        return cost;
    }

}
