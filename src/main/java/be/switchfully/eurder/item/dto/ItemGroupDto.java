package be.switchfully.eurder.item.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ItemGroupDto {
    private final UUID itemId;
    private final int amountOrdered;
    private final BigDecimal itemGroupPrice;
    private final LocalDate shippingDate;

    public ItemGroupDto(String itemId, int amountOrdered, BigDecimal itemGroupPrice, LocalDate shippingDate) {
        this.itemId = UUID.fromString(itemId);
        this.amountOrdered = amountOrdered;
        this.itemGroupPrice = itemGroupPrice;
        this.shippingDate = shippingDate;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public BigDecimal getItemGroupPrice() {
        return itemGroupPrice;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
