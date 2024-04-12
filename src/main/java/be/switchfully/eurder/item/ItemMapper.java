package be.switchfully.eurder.item;

import be.switchfully.eurder.item.domain.Item;
import be.switchfully.eurder.item.dto.ItemDto;
import be.switchfully.eurder.item.dto.NewItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item mapItemDtoToItem(NewItemDto newItemDto) {
        return new Item(newItemDto.getName(),
                        newItemDto.getDescription(),
                        newItemDto.getPrice(),
                        newItemDto.getAvailableAmount(),
                        newItemDto.getDamage());
    }
}
