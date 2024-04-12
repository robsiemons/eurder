package be.switchfully.eurder.item;

import be.switchfully.eurder.item.domain.Item;
import be.switchfully.eurder.item.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class ItemRepository {
    private final List<Item> itemList;

    public ItemRepository(List<Item> itemList) {
        this.itemList = new ArrayList<>();
    }

    public void addNewItem(Item item) {
        itemList.add(item);
    }

    public Map<String, Integer> getStock(List<UUID> uuidList) {
        Map<String, Integer> returnList = new HashMap<>();
        for (UUID itemId: uuidList) {
            Optional<Item> item = itemList.stream()
                    .filter(item1 -> item1.getItemId().equals(itemId))
                    .findFirst();

            if (item.isEmpty()) {
                throw new ItemNotFoundException(itemId.toString());
            } else {
                returnList.put(itemId.toString(), item.get().getStockAmount());
            }
        }
        return returnList;
    }
}
