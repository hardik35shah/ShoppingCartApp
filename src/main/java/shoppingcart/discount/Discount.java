package shoppingcart.discount;

import java.math.BigDecimal;

public interface Discount {
    double applyDiscount(double billingAmountWithoutDiscount);
}
