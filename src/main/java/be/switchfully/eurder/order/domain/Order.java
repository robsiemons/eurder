package be.switchfully.eurder.order.domain;

import be.switchfully.eurder.item.domain.ItemGroup;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final UUID customerId;
    private final BigDecimal orderPrice;
    private final List<ItemGroup> itemGroupList;

    public Order(String customerId, BigDecimal orderPrice, List<ItemGroup> itemGroupList) {
        this.orderPrice = orderPrice;
        this.orderId = UUID.randomUUID();
        this.customerId = UUID.fromString(customerId);
        this.itemGroupList = itemGroupList;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }
    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }
}
