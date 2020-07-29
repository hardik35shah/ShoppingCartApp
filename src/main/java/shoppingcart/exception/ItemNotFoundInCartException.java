package shoppingcart.exception;

public class ItemNotFoundInCartException extends RuntimeException {

    public ItemNotFoundInCartException(String message) {
        super(message);
    }
}
