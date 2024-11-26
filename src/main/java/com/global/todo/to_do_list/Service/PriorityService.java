package Service;

import Model.Priority;
import Repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {
    private  PriorityRepo priorityRepo;

    @Autowired
    public PriorityService(PriorityRepo priorityRepo) {
        this.priorityRepo = priorityRepo;
    }

    public Priority addPriority(Priority priority) {
        // Example of input validation (modify according to your fields)
        if (priority.getName() == null || priority.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Priority title cannot be null or empty");
        }
        return priorityRepo.save(priority);
    }


    /**
     * Retrieve all Priorities.
     * @return List of all Priorities.
     */
    public List<Priority> getAllPriorities() {
        return priorityRepo.findAll();
    }

    /**
     * Retrieve a specific priority by its ID.
     * @param id The ID of the priority.
     * @return An Optional containing the priority if found, or empty otherwise.
     */
    public Optional<Priority> getPriorityById(int id) {
        return priorityRepo.findById(id);
    }

    /**
     * Search for priorities by their names.
     * @param name The name to search for.
     * @return List of priorities matching the given name.
     */
    public List<Priority> searchPriorityByName(String name) {
        return priorityRepo.findByName(name);
    }

    /**
     * Delete a ToDoList by its ID.
     * @param id The ID of the ToDoList to delete.
     * @throws IllegalArgumentException if the ToDoList with the given ID does not exist.
     */
    public void deletePriorityById(int id) {
        if (priorityRepo.existsById(id)) {
            priorityRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Priority with ID " + id + " does not exist.");
        }
    }
}
