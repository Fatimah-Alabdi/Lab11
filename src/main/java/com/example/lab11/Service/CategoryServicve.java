package com.example.lab11.Service;

import com.example.lab11.Api.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Reposetory.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServicve {
    private final CategoryRepository categoryRepository;
    public List<Category> findAll(){
          return (List<Category>) categoryRepository.findAll();
    }
    public void AddCategory(Category category){
        categoryRepository.save(category);
    }
    public void aupdateCategory(Integer id,Category category){
        Category category1 = categoryRepository.findCategoryById(id);
        if(category1 == null){
            throw new ApiExeption("no such category");
        }
        category1.setName(category.getName());
        categoryRepository.save(category1);

    }
    public void deleteCategory(Integer id){
        Category category1 = categoryRepository.findCategoryById(id);
        if(category1 == null){
            throw new ApiExeption("no such category");
        }
        categoryRepository.delete(category1);

    }
    public List<Category> findByCategoryName(String categoryName){
        return categoryRepository.findCategoryByName(categoryName);

    }
}
