package be.switchfully.eurder.order.dto;

import be.switchfully.eurder.customer.domain.Customer;
import be.switchfully.eurder.item.domain.ItemGroup;
import be.switchfully.eurder.item.dto.NewItemGroupDto;

import java.util.List;
import java.util.UUID;

public class NewOrderDto {
    private final List<NewItemGroupDto> itemGroupList;

    public NewOrderDto(List<NewItemGroupDto> itemGroupList) {
        this.itemGroupList = itemGroupList;
    }

    public List<NewItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}
