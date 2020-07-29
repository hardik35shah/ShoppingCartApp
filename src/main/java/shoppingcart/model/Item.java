package shoppingcart.model;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                Objects.equals(itemname, item.itemname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemname, price);
    }
}
