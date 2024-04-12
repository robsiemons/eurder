package be.switchfully.eurder.order;

import be.switchfully.eurder.order.domain.Order;
import be.switchfully.eurder.order.dto.NewOrderDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    public void placeOrder(String customerId, NewOrderDto newOrderDto) {

        Order order = orderMapper.mapNewOrderDtoToOrder(customerId, newOrderDto);
        orderRepository.placeOrder(order);
    }
}
