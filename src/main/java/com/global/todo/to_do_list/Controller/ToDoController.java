package com.global.todo.to_do_list.Controller;

import com.global.todo.to_do_list.Model.ToDo;
import com.global.todo.to_do_list.Repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoRepo toDoRepo;

    @GetMapping("getalltodos")
    public List<ToDo> findAll(){
        return toDoRepo.findAll();
    }

    @GetMapping("gettodosbyid/{id}")
    public Optional<ToDo> findById(@PathVariable int id){
        return toDoRepo.findById(id);
    }

    @GetMapping("gettodosbytitle/{title}")
    public List<ToDo> findByTitle(@PathVariable String title){
        return toDoRepo.findByTitle(title);
    }

    @PutMapping("/updatetodocompleted/{id}")
    public ToDo markToDoAsCompleted(@PathVariable int id) {
        Optional<ToDo> toDoOptional = toDoRepo.findById(id);
        ToDo toDo = toDoOptional.get();
        toDo.setCompleted(true);  // Set the task as completed
        return toDoRepo.save(toDo);  // Save the updated ToDo
    }

    @GetMapping("/list/{toDoListId}")
    public List<ToDo> getToDosByListId(@PathVariable int toDoListId) {
        return toDoRepo.findByTodoListId(toDoListId);
    }

    @GetMapping("gettodosbylistitle/{title}")
    public List<ToDo> findByToDoList_Titlettle(@PathVariable String title){
        return toDoRepo.findByToDoList_Title(title);
    }

    @PostMapping("/addtodo")
    public ToDo addToDo(@RequestBody ToDo toDo){
        return toDoRepo.save(toDo);
    }


    @DeleteMapping("/deletetodobyid/{id}")
    public void deleteById(@PathVariable int id) {
        toDoRepo.deleteById(id);
    }
}
