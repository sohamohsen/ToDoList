package com.global.todo.to_do_list.Repository;

import com.global.todo.to_do_list.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Integer> {
}
