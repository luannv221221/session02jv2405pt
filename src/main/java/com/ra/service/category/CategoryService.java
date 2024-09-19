package com.ra.service.category;

import com.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findCategoryById(Long id);
    void delete(Long id);
    // phan trang
    Page<Category> paginate(Pageable pageable);
}
