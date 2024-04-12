package be.switchfully.eurder.item.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final UUID itemId;
    private final int amountOrdered;
    private final BigDecimal itemGroupPrice;
    private final LocalDate shippingDate;

    public ItemGroup(UUID itemId, int amountOrdered, BigDecimal itemGroupPrice, int stockAmount) {
        this.itemId = itemId;
        this.amountOrdered = amountOrdered;
        this.itemGroupPrice = itemGroupPrice;
        this.shippingDate = calculateShippingDate(stockAmount);
    }


    public UUID getItemId(){
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public BigDecimal getItemGroupPrice() {
        return itemGroupPrice;
    }

    public LocalDate calculateShippingDate(int stockAmount) {

        if(stockAmount >= this.amountOrdered){
            return LocalDate.now().plusDays(1);
        }
        else {
            return LocalDate.now().plusWeeks(1);
            //return LocalDate.now().plusDays(7);
        }
    }
}
