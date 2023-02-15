package ng.com.nigeriandailies.items.controller;

import ng.com.nigeriandailies.items.mode.Item;
import ng.com.nigeriandailies.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody Item item){
        try{
            return new ResponseEntity<>(itemService.create(item), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/item")
    public ResponseEntity<?> getAllItems(){
        try {
            return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/item/{name}")
    public ResponseEntity<?> getItemByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(itemService.getItemByName(name), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateItem (@PathVariable Long id, @RequestBody Item item){
        try {
            return  new ResponseEntity<>(itemService.updateItem(id, item), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem (@PathVariable Long id){
        try {
            itemService.deleteItem(id);
            return  new ResponseEntity<>("Item deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

   }

}
