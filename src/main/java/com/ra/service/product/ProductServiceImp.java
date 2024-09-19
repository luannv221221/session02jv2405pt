package com.ra.service.product;

import com.ra.model.dto.response.ProductResponseDTO;
import com.ra.model.entity.Product;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponseDTO> findAll() {
        // biến đỏi từ entity ==> DTO
        List<Product> products = this.productRepository.findAll();
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        return products.stream().map(entity->
                new ProductResponseDTO(entity.getProductId(),
                        entity.getProductName(),
                        entity.getPrice(),
                        entity.getImage(),
                        entity.getCategory().getCategoryName())).collect(Collectors.toList());

    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
