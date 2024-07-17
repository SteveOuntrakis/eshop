package service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.CustomerCategory;
import com.travelcompany.eshop.model.Itineraries;
import com.travelcompany.eshop.model.PaymentMethod;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Scanner;

public final class TicketService {

    public TicketService() {
        Customer customer = new Customer(1, "Stefanos", "Stefanos@gmail.com", CustomerCategory.BUSINESS);
        Itineraries itineraries = new Itineraries(1, "ATH", "PAR", new Date(), "Skylines", new BigDecimal(300));
        BigDecimal payment_method_discount = paymentMethod();
        costBreakdown(customer, itineraries, payment_method_discount);
    }

    public BigDecimal paymentMethod() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal payment_method_discount = null;
        do {

            System.out.println("Please type 1 for Credit card, 2 for Cash or 0 for .");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int payment_method = scanner.nextInt();
            if (payment_method == 1 || payment_method == 2) {
                payment_method_discount = (PaymentMethod.CREDIT_CARD.getDiscount()).setScale(2, RoundingMode.HALF_UP);
                break;
            } else if (payment_method == 0) {
                System.exit(payment_method);
            }
        } while (true);
        return payment_method_discount;

    }

    public void costBreakdown(Customer customer, Itineraries itineraries, BigDecimal payment_method_discount) {
        var total_discount = payment_method_discount.add(customer.getCategory().getDiscount());
        var cost = itineraries.getPrice()
                .subtract(itineraries.getPrice()
                        .multiply(total_discount))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println(cost);
    }

}
