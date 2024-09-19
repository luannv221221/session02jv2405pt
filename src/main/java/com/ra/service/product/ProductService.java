package com.ra.service.product;

import com.ra.model.dto.response.ProductResponseDTO;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductResponseDTO> findAll(Pageable pageable);
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
