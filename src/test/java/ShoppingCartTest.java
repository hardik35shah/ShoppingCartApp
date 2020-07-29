import org.junit.Before;
import org.junit.Test;
import shoppingcart.exception.CartIsEmptyException;
import shoppingcart.exception.ItemNotFoundInCartException;
import shoppingcart.model.CustomerType;
import shoppingcart.model.Item;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;
    Item item;

    @Before
    public void setUp(){
       shoppingCart=new ShoppingCart();
       item=new Item("Bread",10);
    }

    @Test
    public void addOneItemToCart() {
        shoppingCart.addItemToCart(item);
        assertEquals(1, shoppingCart.getCartItems().size());
    }

    @Test
    public void removeItemFromCart() {
        shoppingCart.addItemToCart(item);
        shoppingCart.removeItemFromCart(item);
        assertEquals(0, shoppingCart.getCartItems().size());
    }

    @Test(expected = ItemNotFoundInCartException.class)
    public void removeItemFromCartThrowsException() {
        shoppingCart.removeItemFromCart(item);
    }

    @Test(expected = CartIsEmptyException.class)
    public void checkoutWithEmptyCart(){
        shoppingCart.getBillingAmount();
    }
    @Test
    public void checkoutForPremiumCustomerWithDiscount10(){
        shoppingCart.setCustomerType(CustomerType.Premium);
        shoppingCart.addItemToCart(new Item("WashingMachine",2000));

        shoppingCart.addItemToCart(new Item("TV",2000));
        assertEquals(3600,shoppingCart.getBillingAmount(),0.01);
    }
    @Test
    public void checkoutForPremiumCustomerWithDiscount15(){
        shoppingCart.setCustomerType(CustomerType.Premium);
        shoppingCart.addItemToCart(new Item("WashingMachine",4000));

        shoppingCart.addItemToCart(new Item("TV",4000));
        assertEquals(7000,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void checkoutForPremiumCustomerWithDiscount20(){
        shoppingCart.setCustomerType(CustomerType.Premium);
        shoppingCart.addItemToCart(new Item("WashingMachine",6000));

        shoppingCart.addItemToCart(new Item("TV",6000));
        assertEquals(10200,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void checkoutForPremiumCustomerWithDiscount30(){
        shoppingCart.setCustomerType(CustomerType.Premium);
        shoppingCart.addItemToCart(new Item("WashingMachine",10000));

        shoppingCart.addItemToCart(new Item("TV",10000));
        assertEquals(15800,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void checkoutForRegularCustomerWithNoDiscount(){
        shoppingCart.setCustomerType(CustomerType.Regular);
        shoppingCart.addItemToCart(new Item("WashingMachine",3000));

        shoppingCart.addItemToCart(new Item("WashingMachine",2000));
        assertEquals(5000,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void checkoutForRegularCustomerWithDiscount10(){
        shoppingCart.setCustomerType(CustomerType.Regular);
        shoppingCart.addItemToCart(new Item("WashingMachine",8000));

        shoppingCart.addItemToCart(new Item("TV",2000));
        assertEquals(9500,shoppingCart.getBillingAmount(),0.01);
    }
    @Test
    public void checkoutForRegularCustomerWithDiscount20(){
        shoppingCart.setCustomerType(CustomerType.Regular);
        shoppingCart.addItemToCart(new Item("WashingMachine",8000));

        shoppingCart.addItemToCart(new Item("TV",7000));
        assertEquals(13500,shoppingCart.getBillingAmount(),0.01);
    }



}
