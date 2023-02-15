package ng.com.nigeriandailies.items.repository;

import ng.com.nigeriandailies.items.mode.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    Item findItemsByName(String name);
}
