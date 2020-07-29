import shoppingcart.exception.CartIsEmptyException;
import shoppingcart.exception.ItemNotFoundInCartException;
import shoppingcart.model.CustomerType;
import shoppingcart.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> cartItems=new ArrayList<>();
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

    public void removeItemFromCart(Item item){
        if(cartItems.contains(item))
            cartItems.remove(item);
        else
            throw new ItemNotFoundInCartException("Item Not found");
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType=customerType;
    }

    public double getBillingAmount(){

        if(cartItems.isEmpty()){
            throw new CartIsEmptyException("Cart is Empty.Please add at least on item.");
        }
        double billingAmountWithoutDiscount=cartItems.stream().mapToDouble(Item::getPrice).sum();
        return billingAmountWithoutDiscount-customerType.getDiscount().applyDiscount(billingAmountWithoutDiscount);
    }
}
