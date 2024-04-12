package be.switchfully.eurder.order;

import be.switchfully.eurder.item.dto.NewItemGroupDto;
import be.switchfully.eurder.order.dto.NewOrderDto;
import be.switchfully.eurder.security.Feature;
import be.switchfully.eurder.security.SecurityService;
import be.switchfully.eurder.security.exceptions.LoginException;
import be.switchfully.eurder.security.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestHeader(value = "Authorization") String auth,
                                 @RequestBody NewOrderDto newOrderDto){
        try {
            securityService.validateCustomerAuthorization(auth, Feature.PLACE_NEW_ORDER);
        } catch (UnauthorizedException | LoginException exception) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage(), exception);
        }

        String customerId = securityService.getUserUUIDForCustomer(auth);
        orderService.placeOrder(customerId, newOrderDto);
    }
}
