package be.switchfully.eurder.order;

import be.switchfully.eurder.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orderList;

    public OrderRepository(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void placeOrder(Order order) {
        orderList.add(order);
    }
}
