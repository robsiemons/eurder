package be.switchfully.eurder.order;

import be.switchfully.eurder.item.domain.ItemGroup;
import be.switchfully.eurder.item.dto.NewItemGroupDto;
import be.switchfully.eurder.order.domain.Order;
import be.switchfully.eurder.order.dto.NewOrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapNewOrderDtoToOrder(String customerId, NewOrderDto newOrderDto){
        List<ItemGroup> itemGroupList = getItemGroupList(newOrderDto).stream()
                .map(itemgroupMapper::mapNewItemGroupDtoToItemGroup)
                .collect(Collectors.toList());


        return new Order(customerId, totalPrice, itemGroupList);
    }

    private List<NewItemGroupDto> getItemGroupList(NewOrderDto newOrderDto) {
        return newOrderDto.getItemGroupList().stream()
                .map(itemGroupDto -> new NewItemGroupDto(itemGroupDto.getItemId(),
                                                         itemGroupDto.getAmountOrdered()))
                .collect(Collectors.toList());
    }

}
