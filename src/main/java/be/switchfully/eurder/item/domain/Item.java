package be.switchfully.eurder.item.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    private final UUID itemId;
    private String name, description;
    private BigDecimal itemPrice;
    private int stockAmount;
    private ItemState damage;

    public Item(String name, String description, BigDecimal itemPrice, int stockAmount, ItemState damage) {
        this.itemId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.itemPrice = itemPrice;
        this.stockAmount = stockAmount;
        this.damage = damage;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public ItemState getDamage() {
        return damage;
    }

    public void setDamage(ItemState damage) {
        this.damage = damage;
    }
}
