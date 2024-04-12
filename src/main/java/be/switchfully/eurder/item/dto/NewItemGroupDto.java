package be.switchfully.eurder.item.dto;

import java.util.UUID;

public class NewItemGroupDto {
    private final UUID itemId;
    private final int amountOrdered;

    public NewItemGroupDto(UUID itemId, int amountOrdered) {
        this.itemId = itemId;
        this.amountOrdered = amountOrdered;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

}
