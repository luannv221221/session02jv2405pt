package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;
    @Column(name = "product_name",length = 100,nullable = false,unique = true)
    private String productName;
    @Column(name = "price")
    private Double price;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    @JsonIgnore
    private Category category;

}
