package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Category;
import com.example.lab11.Reposetory.CategoryRepository;
import com.example.lab11.Service.CategoryServicve;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServicve categoryServicve;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryServicve.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity AddCategory(@Valid@RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        categoryServicve.AddCategory(category);
        return ResponseEntity.status(201).body(new ApiResponse("Category added successfully"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@Valid@RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        categoryServicve.aupdateCategory(id,category);
        return ResponseEntity.status(200).body(new ApiResponse("Category updated successfully"));
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        categoryServicve.deleteCategory(id);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted successfully"));
    }
    @GetMapping("/get_categories_by_name/{name}")
    public ResponseEntity getAllCategoryByname(@PathVariable String name){
        List<Category> c1= categoryServicve.findByCategoryName(name);
        return ResponseEntity.status(200).body(c1);

    }

}
