package com.global.todo.to_do_list.Service;

import com.global.todo.to_do_list.Model.ToDo;
import com.global.todo.to_do_list.Repository.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private  ToDoRepo toDoRepo;


    public Optional<ToDo> markToDoAsCompleted(int id) {
        // Retrieve the ToDo item by id
        Optional<ToDo> optionalToDo = toDoRepo.findById(id);

        // Check if the ToDo item exists
        if (optionalToDo.isPresent()) {
            ToDo toDo = optionalToDo.get();
            // Mark it as completed
            toDo.setCompleted(true);
            // Save the updated ToDo item
            return Optional.of(toDoRepo.save(toDo));
        }

        // If the ToDo item does not exist, return an empty Optional
        return Optional.empty();
    }


    public int count(){
        return (int) toDoRepo.count();
    }

    public ToDo addToDo (ToDo toDo){
        return toDoRepo.save(toDo);
    }

    public List<ToDo> findAll(){
        return toDoRepo.findAll();
    }

    public Optional<ToDo> findById (int id){
        return toDoRepo.findById(id);
    }

    public List<ToDo> findByTodoListId(int toDoListId) {
        return toDoRepo.findByTodoListId(toDoListId);
    }


//    public List<ToDo> findByListTitle(String title) {
//        return toDoRepo.findByToDoList_Title(title);
//    }


    public List<ToDo> findByTitle(String title){
        return toDoRepo.findByTitle(title);
    }

    public void DeleteToDo(int id){
        toDoRepo.deleteById(id);
    }

}
