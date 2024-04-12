package be.switchfully.eurder.item;

import be.switchfully.eurder.item.dto.NewItemDto;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public void addNewItem(NewItemDto newItemDto) {
        itemRepository.addNewItem(
                itemMapper.mapItemDtoToItem(newItemDto));
    }
}
