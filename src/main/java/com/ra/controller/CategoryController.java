package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<>(categoryNew,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id,@RequestBody Category category){
        category.setCategoryId(id);
        Category categoryUpdate = categoryService.save(category);
        return new ResponseEntity<>(categoryUpdate,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
