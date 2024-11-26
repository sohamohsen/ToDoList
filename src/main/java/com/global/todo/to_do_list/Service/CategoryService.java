package Service;

import Model.Category;
import Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    private CategoryRepo categoryRepo;
    @Autowired
    public void CategoriesRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category) {
        // Example of input validation (modify according to your fields)
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Priority title cannot be null or empty");
        }
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    public List<Category> searchForCategoryByName(String name) {
        return categoryRepo.findByName(name);
    }

    public void deleteCategoryById(int id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Category with ID " + id + " does not exist.");
        }
    }
}
