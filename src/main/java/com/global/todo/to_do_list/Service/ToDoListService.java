package com.global.todo.to_do_list.Service;

import com.global.todo.to_do_list.Model.ToDoList;
import com.global.todo.to_do_list.Repository.ToDoListRepo;
import com.global.todo.to_do_list.Repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepo toDoListRepo;
    private final ToDoRepo toDoRepo;

    @Autowired
    public ToDoListService(ToDoListRepo toDoListRepo, ToDoRepo toDoRepo) {
        this.toDoListRepo = toDoListRepo;
        this.toDoRepo = toDoRepo;
    }

    // Method to create and save a new ToDoList
    public ToDoList createToDoList(ToDoList toDoList) {
        // Ensure that the `toDoList` object is properly populated before saving
        return toDoListRepo.save(toDoList);
    }

    public List<ToDoList> findAll(){
        return toDoListRepo.findAll();
    }

    public Optional<ToDoList> findById(int id){
        return toDoListRepo.findById(id);
    }

    public List<ToDoList> findByTitle(String title){
        return toDoListRepo.findByTitle(title);
    }

    public void DeleteToDoList(int id){
        toDoListRepo.deleteById(id);
    }
}
