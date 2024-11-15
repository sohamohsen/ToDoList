package com.global.todo.to_do_list.Repository;

import com.global.todo.to_do_list.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Integer> {

    List<ToDo> findByTitle(String title);

    @Query("SELECT t FROM ToDo t WHERE t.toDoListId = :toDoListId")
    List<ToDo> findByTodoListId(@Param("toDoListId") int toDoListId);

}
