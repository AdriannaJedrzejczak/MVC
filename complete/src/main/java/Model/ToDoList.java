package Model;

import dao.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoList  implements toDoListService{
    private List<Item> toDoList = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        item.setId(getNextId());
        this.toDoList.add(item);
    }

    @Override
    public List<Item> deleteItem(Integer id) {
        toDoList.remove(findElementIndex(id) );
        return this.toDoList;
    }

    @Override
    public List<Item> getItems() {
        return this.toDoList;
    }

    public Integer getNextId() {
        int maxId = 0;
        for(int i =0; i< toDoList.size(); i++ ) {
            if(toDoList.get(i).getId() > maxId) {
                maxId = toDoList.get(i).getId();
            }
        }
        return ++maxId;
    }

    public Integer findElementIndex(int id) {
        int elementIndex = 0;
        for(int i =0; i< toDoList.size(); i++ ) {
            if(toDoList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
