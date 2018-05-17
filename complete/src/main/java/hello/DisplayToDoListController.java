package hello;

import Model.ToDoList;
import Model.toDoListService;
import dao.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DisplayToDoListController {

    //@Autowired
   toDoListService toDoListService = new ToDoList();

    @GetMapping("/toDoList")
    public String displayList(Model model) {
        toDoListService.addItem( new Item(){{setId(1); setDesc("aaua"); }});
        toDoListService.addItem( new Item(){{setId(2); setDesc("yhedt"); }});
        toDoListService.addItem( new Item(){{setId(13); setDesc("jmf"); }});


        model.addAttribute("items", toDoListService.getItems());
        model.addAttribute("newItem", new Item());
        return "itemsList";
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute Item item) {
        toDoListService.addItem(item);
        System.out.println("item: " + item.getDesc());
        model.addAttribute("items", toDoListService.getItems());
        model.addAttribute("newItem", new Item());

        return "itemsList";
    }


    @RequestMapping(value = "/addItem", params = {"deleteItem"})
    public String del(Model model,
                      final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("deleteItem"));
        System.out.println( "iteto delete: " + rowId);
        toDoListService.deleteItem(rowId);
        model.addAttribute("items", toDoListService.getItems());
        model.addAttribute("newItem", new Item());


        return "itemsList";
    }

    @RequestMapping(value = "/deleteItem",method = RequestMethod.GET)
    public String delete(Model model,
                      @ModelAttribute Item item) {
        toDoListService.deleteItem(item.getId());
        System.out.println("item: " + item.getDesc());
        model.addAttribute("items", toDoListService.getItems());
       // model.addAttribute("newItem", new Item());

        return "itemsList";
    }


}
