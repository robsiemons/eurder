package be.switchfully.eurder.item.dto;

import java.math.BigDecimal;

public class ItemDto {
    private final String name;
    private final String description;
    private final BigDecimal price;

    public ItemDto(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
