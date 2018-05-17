package Model;

import dao.Item;

import java.util.List;

public interface toDoListService {
    void addItem(Item item);
    List<Item> deleteItem(Integer item);
    List<Item> getItems();
}
