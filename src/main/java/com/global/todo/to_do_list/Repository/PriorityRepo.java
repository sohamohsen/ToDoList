package com.global.todo.to_do_list.Repository;

import com.global.todo.to_do_list.Model.Priority;
import com.global.todo.to_do_list.Model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface PriorityRepo extends JpaRepository<Priority, Integer> {
    List<ToDoList> findByName(String name);

}
