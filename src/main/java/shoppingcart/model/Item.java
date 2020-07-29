package shoppingcart.model;


public class Item {
    private String itemname;
    private double price;

    public Item(String itemname, double price) {
        this.itemname = itemname;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
