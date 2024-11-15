package com.global.todo.to_do_list.Controller;

import com.global.todo.to_do_list.Model.ToDoList;
import com.global.todo.to_do_list.Repository.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {

    @Autowired
    private ToDoListRepo toDoListRepo;

    @GetMapping("/getalllists")
    public List<ToDoList> findAll(){
        return toDoListRepo.findAll();
    }

    @GetMapping("/getlistbyid/{id}")
    public Optional<ToDoList> findById(@PathVariable int id){
        return toDoListRepo.findById(id);
    }

    @GetMapping("/getlistbyid/{title}")
    public List<ToDoList> findByTitle(@PathVariable String title){
        return toDoListRepo.findByTitle(title);
    }

    @PostMapping("/createnewlist")
    public ToDoList createNewList(@RequestBody ToDoList toDoList){
        return toDoListRepo.save(toDoList);
    }

    @DeleteMapping("/deletelistbyid/{id}")
    public void deleteListById(@PathVariable int id){
        toDoListRepo.deleteById(id);
    }
}
