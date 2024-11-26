package Controller;

import Model.Priority;
import Repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    @Autowired
    private PriorityRepo priorityRepo;

    @GetMapping("/prioritylist")
    public List<Priority> findAll (){
        return priorityRepo.findAll();
    }
}
