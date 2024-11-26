package Controller;

import Model.ToDoList;
import Repository.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todolists")
public class ToDoListController {

    @Autowired
    private ToDoListRepo toDoListRepo;

    /**
     * Retrieve all ToDoLists
     * @return List of all ToDoLists
     */
    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllToDoLists() {
        List<ToDoList> toDoLists = toDoListRepo.findAll();
        return ResponseEntity.ok(toDoLists);
    }

    /**
     * Retrieve a specific ToDoList by its ID
     * @param id ID of the ToDoList
     * @return ToDoList if found, otherwise 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable int id) {
        Optional<ToDoList> toDoListOptional = toDoListRepo.findById(id);
        return toDoListOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Search ToDoLists by their title
     * @param title Title of the ToDoList
     * @return List of matching ToDoLists, or 204 No Content if none found
     */
    @GetMapping("/search/by-title/{title}")
    public ResponseEntity<List<ToDoList>> searchToDoListsByTitle(@PathVariable String title) {
        List<ToDoList> toDoLists = toDoListRepo.findByTitle(title);
        return toDoLists.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(toDoLists);
    }

    /**
     * Create a new ToDoList
     * @param toDoList ToDoList object to be created
     * @return The newly created ToDoList
     */
    @PostMapping
    public ResponseEntity<ToDoList> createToDoList(@RequestBody ToDoList toDoList) {
        ToDoList savedToDoList = toDoListRepo.save(toDoList);
        return ResponseEntity.ok(savedToDoList);
    }

    /**
     * Delete a ToDoList by its ID
     * @param id ID of the ToDoList to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoListById(@PathVariable int id) {
        if (toDoListRepo.existsById(id)) {
            toDoListRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
