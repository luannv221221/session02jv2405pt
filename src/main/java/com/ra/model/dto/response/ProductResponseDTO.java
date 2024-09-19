package com.ra.model.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private Double price;
    private String image;
    private String categoryName;
}
