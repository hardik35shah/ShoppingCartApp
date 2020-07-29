package shoppingcart.model;

import shoppingcart.discount.Discount;
import shoppingcart.discount.PrivilegeDiscount;
import shoppingcart.discount.RegularDiscount;

public enum CustomerType {
    Regular(new RegularDiscount()),Privilege(new PrivilegeDiscount());

    private final Discount discount;

    CustomerType(Discount discount) {
        this.discount=discount;
    }

    public Discount getDiscount() {
        return discount;
    }
}
