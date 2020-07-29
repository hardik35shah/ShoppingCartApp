import shoppingcart.model.CustomerType;
import shoppingcart.model.Item;

import java.util.List;

public class ShoppingCart {
    private List<Item> cartItems;
    private CustomerType customerType;

    public List<Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Item> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItemToCart(Item item) {
        cartItems.add(item);
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType=customerType;
    }

    public double getBillingAmount(){
        double billingAmountWithoutDiscount=cartItems.stream().mapToDouble(Item::getPrice).sum();
        return billingAmountWithoutDiscount-customerType.getDiscount().applyDiscount(billingAmountWithoutDiscount);
    }
}
