package ng.com.nigeriandailies.items.service;

import ng.com.nigeriandailies.items.mode.Item;
import ng.com.nigeriandailies.items.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemsRepository repository;

    @Override
    public Item create(Item item) {
        Item newItem = new Item();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        return repository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return repository.findAll();
    }

    @Override
    public Item getItemByName(String name) {
        return repository.findItemsByName(name);
    }


   @Override
    public Item updateItem(Long id, Item item) {

        Item updateItem = findItemById(id);
        updateItem.setName(item.getName());
        updateItem.setDescription(item.getDescription());
//       updateItem.setCreatedDate(new Date());
//        updateItem.setModifiedDate(new Date());
        return repository.save(updateItem);

    }

    //Helper Method
    private Item findItemById(Long id){
        if (repository.findById(id).isEmpty()){
            System.out.println("Item with this Id does not exist");
        }
        return repository.findById(id).get();
    }

    @Override
   public void deleteItem(Long id) {
          Optional<Item> deleteItem = repository.findById(id);
          repository.delete(deleteItem.get());
    }
}




