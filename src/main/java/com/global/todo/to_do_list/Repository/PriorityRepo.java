package Repository;

import Model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface PriorityRepo extends JpaRepository<Priority, Integer> {
    List<Priority> findByName(String name);

}
