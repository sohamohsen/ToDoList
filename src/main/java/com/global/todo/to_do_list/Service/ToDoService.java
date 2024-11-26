package Service;

import Model.ToDo;
import Repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    @Autowired
    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    /**
     * Marks a ToDo item as completed.
     * @param id The ID of the ToDo item to be marked as completed.
     * @return The updated ToDo item wrapped in an Optional, or an empty Optional if not found.
     */
    public Optional<ToDo> markToDoAsCompleted(int id) {
        return toDoRepo.findById(id).map(toDo -> {
            toDo.setCompleted(true);
            return toDoRepo.save(toDo);
        });
    }

    /**
     * Counts the total number of ToDo items.
     * @return The total count of ToDo items.
     */
    public int countToDos() {
        return (int) toDoRepo.count();
    }

    /**
     * Adds a new ToDo item.
     * @param toDo The ToDo item to be added.
     * @return The saved ToDo item.
     */
    public ToDo addToDo(ToDo toDo) {
        return toDoRepo.save(toDo);
    }

    /**
     * Retrieves all ToDo items.
     * @return A list of all ToDo items.
     */
    public List<ToDo> getAllToDos() {
        return toDoRepo.findAll();
    }

    /**
     * Retrieves a ToDo item by its ID.
     * @param id The ID of the ToDo item.
     * @return The ToDo item wrapped in an Optional, or an empty Optional if not found.
     */
    public Optional<ToDo> getToDoById(int id) {
        return toDoRepo.findById(id);
    }

    /**
     * Retrieves all ToDo items by their list ID.
     * @param toDoListId The ID of the ToDo list.
     * @return A list of ToDo items beinting to the specified list.
     */
    public List<ToDo> getToDosByListId(int toDoListId) {
        return toDoRepo.findByTodoListId(toDoListId);
    }

    /**
     * Retrieves ToDo items by their list title.
     * @param title The title of the ToDo list.
     * @return A list of ToDo items beinting to lists with the specified title.
     */
    public List<ToDo> getToDosByListTitle(String title) {
        return toDoRepo.findByToDoListTitle(title);
    }

    /**
     * Retrieves all ToDo items by their priority ID.
     * @param priorityId The ID of the ToDo priority.
     * @return A list of ToDo items beinting to the specified priority.
     */
    public List<ToDo> findByPriorityId(int priorityId) {
        return toDoRepo.findByPriorityId(priorityId);
    }

    /**
     * Retrieves ToDo items by their priority name.
     * @param name The priority name of the ToDo items.
     * @return A list of ToDo items matching the specified priority name.
     */
    public List<ToDo> getToDosByPriorityName(String name) {
        return toDoRepo.findByToDoPriorityName(name);
    }

    /**
     * Deletes a ToDo item by its ID.
     * @param id The ID of the ToDo item to be deleted.
     * @throws IllegalArgumentException if the ToDo item with the specified ID does not exist.
     */
    public void deleteToDoById(int id) {
        if (toDoRepo.existsById(id)) {
            toDoRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("ToDo with ID " + id + " does not exist.");
        }
    }
}
