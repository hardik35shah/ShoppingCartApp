import model.Item;

import java.math.BigDecimal;
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
        double billingAmountWithoutDiscount=cartItems.stream().mapToDouble(item->item.getPrice()).sum();
        double billingAmount= billingAmountWithoutDiscount-customerType.getDiscount().applyDiscount(billingAmountWithoutDiscount);
        return  billingAmount;
    }
}
