package Repository;

import Model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepo extends JpaRepository <ToDoList, Integer> {
    List<ToDoList> findByTitle(String title);

}
