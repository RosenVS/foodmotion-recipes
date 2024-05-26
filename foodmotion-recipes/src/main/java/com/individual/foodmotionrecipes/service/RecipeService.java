package com.individual.foodmotionrecipes.service;

import com.individual.foodmotionrecipes.model.Recipe;
import com.individual.foodmotionrecipes.model.Status;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Optional<Recipe> getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
    Recipe updateRecipeStatus(Long id, Status status);
    List<Recipe> getAllRecipesByChefId(String chefId);
    List<Recipe> getAllApprovedRecipes();
}
