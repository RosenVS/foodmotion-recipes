package com.individual.foodmotionrecipes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;
    private String chef_id;
    private String title;

    private String description;
    private String cookingTime;


    @ElementCollection
    @CollectionTable(name = "food_products", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "food_product")
    private List<Long> foodProducts = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private CaloriesPerServing caloriesPerServing;

}
