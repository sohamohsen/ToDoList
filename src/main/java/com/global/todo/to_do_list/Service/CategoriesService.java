package com.global.todo.to_do_list.Service;

import com.global.todo.to_do_list.Repository.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    private CategoriesRepo categoriesRepo;
    @Autowired
    public void CategoriesRepo(CategoriesRepo categoriesRepo) {
        this.categoriesRepo = categoriesRepo;
    }
}
