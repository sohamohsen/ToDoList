package com.global.todo.to_do_list.Controller;

import com.global.todo.to_do_list.Model.ToDo;
import com.global.todo.to_do_list.Repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoRepo toDoRepo;

    /**
     * Retrieve all ToDo entries
     * @return List of all ToDos
     */
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = toDoRepo.findAll();
        return ResponseEntity.ok(todos);
    }

    /**
     * Retrieve a specific ToDo by its ID
     * @param id ID of the ToDo
     * @return ToDo entry if found, otherwise 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable int id) {
        Optional<ToDo> toDoOptional = toDoRepo.findById(id);
        return toDoOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Search ToDo entries by their title
     * @param title Title of the ToDo
     * @return List of matching ToDo entries, or 204 No Content if none found
     */
    @GetMapping("/search/by-title/{title}")
    public ResponseEntity<List<ToDo>> searchToDosByTitle(@PathVariable String title) {
        List<ToDo> todos = toDoRepo.findByTitle(title);
        return todos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(todos);
    }

    /**
     * Mark a ToDo entry as completed
     * @param id ID of the ToDo to update
     * @return Updated ToDo entry if found, otherwise 404 Not Found
     */
    @PutMapping("/{id}/mark-completed")
    public ResponseEntity<ToDo> markToDoAsCompleted(@PathVariable int id) {
        Optional<ToDo> toDoOptional = toDoRepo.findById(id);

        if (toDoOptional.isPresent()) {
            ToDo toDo = toDoOptional.get();
            toDo.setCompleted(true); // Mark as completed
            ToDo updatedToDo = toDoRepo.save(toDo); // Save changes
            return ResponseEntity.ok(updatedToDo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieve ToDo entries by their associated ToDoList ID
     * @param toDoListId ID of the ToDoList
     * @return List of ToDos associated with the provided ToDoList ID
     */
    @GetMapping("/list/{toDoListId}/todos")
    public ResponseEntity<List<ToDo>> getToDosByListId(@PathVariable int toDoListId) {
        List<ToDo> todos = toDoRepo.findByTodoListId(toDoListId);
        return todos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(todos);
    }

    /**
     * Search ToDo entries by their associated ToDoList title
     * @param title Title of the ToDoList
     * @return List of ToDo entries associated with the provided ToDoList title
     */
    @GetMapping("/list/search/by-title/{title}")
    public ResponseEntity<List<ToDo>> searchToDosByListTitle(@PathVariable String title) {
        List<ToDo> todos = toDoRepo.findByToDoListTitle(title);
        return todos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(todos);
    }

    /**
     * Create a new ToDo entry
     * @param toDo ToDo object to be created
     * @return The newly created ToDo entry
     */
    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        ToDo savedToDo = toDoRepo.save(toDo);
        return ResponseEntity.ok(savedToDo);
    }

    /**
     * Delete a ToDo entry by its ID
     * @param id ID of the ToDo to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable int id) {
        if (toDoRepo.existsById(id)) {
            toDoRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
