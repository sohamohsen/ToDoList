package com.global.todo.to_do_list.Repository;

import com.global.todo.to_do_list.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Integer> {

    /**
     * Finds ToDo items by their title.
     * @param title The title of the ToDo items.
     * @return A list of ToDo items matching the specified title.
     */
    List<ToDo> findByTitle(String title);

    /**
     * Finds ToDo items by the ID of their parent ToDo list.
     * @param toDoListId The ID of the ToDo list.
     * @return A list of ToDo items belonging to the specified ToDo list.
     */
    @Query("SELECT t FROM ToDo t WHERE t.toDoListId = :toDoListId")
    List<ToDo> findByTodoListId(@Param("toDoListId") int toDoListId);

    /**
     * Finds ToDo items by the title of their parent ToDo list.
     * @param title The title of the ToDo list.
     * @return A list of ToDo items belonging to the lists with the specified title.
     */
    @Query("SELECT t FROM ToDo t WHERE t.toDoList.title = :title")
    List<ToDo> findByToDoListTitle(@Param("title") String title);

}
