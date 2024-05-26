package com.individual.foodmotionrecipes.service;

import com.individual.foodmotionrecipes.model.Recipe;
import com.individual.foodmotionrecipes.model.Status;
import com.individual.foodmotionrecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    public List<Recipe> getAllRecipesByChefId(String chefId) {
        return recipeRepository.findByChefId(chefId);
    }
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @Override
    public List<Recipe> getAllApprovedRecipes() {
        return recipeRepository.findByStatus(Status.APPROVED);
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipe.setStatus(Status.PENDING); // Set default status to PENDING
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        if (!recipeRepository.existsById(id)) {
            throw new RuntimeException("Recipe not found");
        }
        recipe.setRecipe_id(id);
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipeStatus(Long id, Status status) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        recipe.setStatus(status);
        return recipeRepository.save(recipe);
    }
}
