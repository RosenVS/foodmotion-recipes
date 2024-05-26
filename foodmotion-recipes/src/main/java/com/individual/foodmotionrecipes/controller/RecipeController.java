package com.individual.foodmotionrecipes.controller;

import com.individual.foodmotionrecipes.dto.StatusUpdateRequest;
import com.individual.foodmotionrecipes.model.Recipe;
import com.individual.foodmotionrecipes.model.Status;
import com.individual.foodmotionrecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = {"http://localhost:3000", "https://foodmotion-frontend-hlfxsphkja-ew.a.run.app","https://foodmotion-api-gateway-6xxrfy77.ew.gateway.dev"})

public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
    @GetMapping("/approved")
    public List<Recipe> getAllApprovedRecipes() {
        return recipeService.getAllApprovedRecipes();
    }
    @GetMapping("/creator/{creatorId}")
    public List<Recipe> getAllRecipesByCreator(@PathVariable("creatorId") String creatorId) {
        return recipeService.getAllRecipesByChefId(creatorId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        recipe.setStatus(Status.PENDING);
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        try {
            return ResponseEntity.ok(recipeService.updateRecipe(id, recipe));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Recipe> updateRecipeStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest statusUpdateRequest) {
        try {
            return ResponseEntity.ok(recipeService.updateRecipeStatus(id, statusUpdateRequest.getStatus()));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}