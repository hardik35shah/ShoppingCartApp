import shoppingcart.model.CustomerType;
import shoppingcart.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @Before
    public void setUp(){
       shoppingCart=new ShoppingCart();
       shoppingCart.setCartItems(new ArrayList<>());
    }

    @Test
    public void addOneItemToCart() {
        shoppingCart.addItemToCart(new Item("Bread",10));
        assertEquals(1, shoppingCart.getCartItems().size());
    }
    @Test
    public void addItemForRegularCustomer(){
        shoppingCart.setCustomerType(CustomerType.Regular);
        shoppingCart.addItemToCart(new Item("WashingMachine",3000));

        shoppingCart.addItemToCart(new Item("WashingMachine",2000));
        assertEquals(5000,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void addZeroItemForRegularCustomer(){
        shoppingCart.setCustomerType(CustomerType.Regular);
        assertEquals(0,shoppingCart.getBillingAmount(),0.01);
    }

    @Test
    public void addItemForPrivilegeCustomer(){
        shoppingCart.setCustomerType(CustomerType.Privilege);
        shoppingCart.addItemToCart(new Item("WashingMachine",10000));

        shoppingCart.addItemToCart(new Item("WashingMachine",10000));
        assertEquals(15800,shoppingCart.getBillingAmount(),0.01);
    }

}
