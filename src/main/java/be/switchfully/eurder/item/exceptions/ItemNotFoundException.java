package be.switchfully.eurder.item.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String itemId) {
        super("Item with id: " + itemId + " not found");
    }
}
