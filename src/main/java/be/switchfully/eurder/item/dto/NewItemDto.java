package be.switchfully.eurder.item.dto;

import be.switchfully.eurder.item.domain.ItemState;

import java.math.BigDecimal;

public class NewItemDto {
    private final String name, description;
    private final BigDecimal price;
    private final int stock;
    private final ItemState damage;

    public NewItemDto(String name, String description, BigDecimal price, int availableAmount, ItemState damage) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = availableAmount;
        this.damage = damage;
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

    public int getAvailableAmount() {
        return stock;
    }

    public ItemState getDamage() {
        return damage;
    }
}
