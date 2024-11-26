package Service;

import Model.ToDoList;
import Repository.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepo toDoListRepo;

    @Autowired
    public ToDoListService(ToDoListRepo toDoListRepo) {
        this.toDoListRepo = toDoListRepo;
    }

    /**
     * Create and save a new ToDoList.
     * @param toDoList The ToDoList to be created.
     * @return The saved ToDoList.
     */
    public ToDoList createToDoList(ToDoList toDoList) {
        // Validate input if necessary before saving
        return toDoListRepo.save(toDoList);
    }

    /**
     * Retrieve all ToDoLists.
     * @return List of all ToDoLists.
     */
    public List<ToDoList> getAllToDoLists() {
        return toDoListRepo.findAll();
    }

    /**
     * Retrieve a specific ToDoList by its ID.
     * @param id The ID of the ToDoList.
     * @return An Optional containing the ToDoList if found, or empty otherwise.
     */
    public Optional<ToDoList> getToDoListById(int id) {
        return toDoListRepo.findById(id);
    }

    /**
     * Search for ToDoLists by their title.
     * @param title The title to search for.
     * @return List of ToDoLists matching the given title.
     */
    public List<ToDoList> searchToDoListsByTitle(String title) {
        return toDoListRepo.findByTitle(title);
    }

    /**
     * Delete a ToDoList by its ID.
     * @param id The ID of the ToDoList to delete.
     * @throws IllegalArgumentException if the ToDoList with the given ID does not exist.
     */
    public void deleteToDoListById(int id) {
        if (toDoListRepo.existsById(id)) {
            toDoListRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("ToDoList with ID " + id + " does not exist.");
        }
    }
}
