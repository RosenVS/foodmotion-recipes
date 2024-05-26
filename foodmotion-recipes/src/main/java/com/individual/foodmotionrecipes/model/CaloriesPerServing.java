package com.individual.foodmotionrecipes.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CaloriesPerServing {
    private double fat;
    private double protein;
    private double carbs;
}