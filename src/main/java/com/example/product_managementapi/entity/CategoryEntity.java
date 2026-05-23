package com.example.product_managementapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //mappedBy helps hibernate to understand which field he needs to
    //take for relationship from ProductEntity and not create a new relationship
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<ProductEntity> products;
}
