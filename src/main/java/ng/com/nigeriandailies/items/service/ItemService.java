package ng.com.nigeriandailies.items.service;

import ng.com.nigeriandailies.items.mode.Item;

import java.util.List;

public interface ItemService {

    Item create(Item item);
    List<Item> getItems();
    Item getItemByName(String name);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}