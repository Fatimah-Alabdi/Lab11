package com.example.lab11.Reposetory;

import com.example.lab11.Model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findCategoryById(Integer id);
    List<Category> findCategoryByName(String name);
}
