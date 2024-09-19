package com.ra.controller;

import com.ra.model.dto.response.ProductResponseDTO;
import com.ra.model.entity.Product;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<Page<ProductResponseDTO>> getAll(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "limit",defaultValue = "3") int limit
    ){
        Pageable pageable = PageRequest.of(page, limit);
        Page<ProductResponseDTO> products = productService.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
