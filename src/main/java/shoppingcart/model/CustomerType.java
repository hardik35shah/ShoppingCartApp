package shoppingcart.model;

import shoppingcart.discount.Discount;
import shoppingcart.discount.PremiumDiscount;
import shoppingcart.discount.RegularDiscount;

public enum CustomerType {
    Regular(new RegularDiscount()),Premium(new PremiumDiscount());

    private final Discount discount;

    CustomerType(Discount discount) {
        this.discount=discount;
    }

    public Discount getDiscount() {
        return discount;
    }
}
