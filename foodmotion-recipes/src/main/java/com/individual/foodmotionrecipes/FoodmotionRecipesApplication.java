package com.individual.foodmotionrecipes;

import com.individual.foodmotionrecipes.model.CaloriesPerServing;
import com.individual.foodmotionrecipes.model.Recipe;
import com.individual.foodmotionrecipes.model.Status;
import com.individual.foodmotionrecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class FoodmotionRecipesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FoodmotionRecipesApplication.class, args);
    }
    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public void run(String... args) throws Exception {
        Recipe recipe1 = new Recipe();
        recipe1.setChef_id("Chef1");
        recipe1.setDescription("Delicious breakfast recipe");
        recipe1.setTitle("Delicious breakfast");
        recipe1.setCookingTime("30");
        recipe1.setFoodProducts(Arrays.asList(1L, 2L)); // Assuming 1L and 2L are valid food product IDs
        CaloriesPerServing recipe1Calories = new CaloriesPerServing();
        recipe1Calories.setCarbs(2.1);
        recipe1Calories.setProtein(1.1);
        recipe1Calories.setFat(3.1);
        recipe1.setCaloriesPerServing(recipe1Calories);
        recipe1.setStatus(Status.PENDING);

        // Create and save Recipe 2
        Recipe recipe2 = new Recipe();
        recipe2.setChef_id("ujhLUcGPp3cujxTrkBjlW3nffEi2");
        recipe2.setDescription("Healthy fruit salad");
        recipe2.setTitle("Fruit salad");
        recipe2.setCookingTime("15");
        CaloriesPerServing recipe2Calories = new CaloriesPerServing();
        recipe2Calories.setCarbs(12.1);
        recipe2Calories.setProtein(8.1);
        recipe2Calories.setFat(8.4);
        recipe2.setCaloriesPerServing(recipe2Calories);
        recipe2.setFoodProducts(Arrays.asList(3L, 4L)); // Assuming 3L and 4L are valid food product IDs
        recipe2.setStatus(Status.APPROVED);

        // Create and save Recipe 3
        Recipe recipe3 = new Recipe();
        recipe3.setChef_id("ujhLUcGPp3cujxTrkBjlW3nffEi2");
        recipe3.setDescription("Quick and easy snack desc");
        recipe3.setTitle("Snack");
        recipe3.setCookingTime("10");
        CaloriesPerServing recipe3Calories = new CaloriesPerServing();
        recipe3Calories.setCarbs(51.1);
        recipe3Calories.setProtein(4.1);
        recipe3Calories.setFat(19.8);
        recipe3.setCaloriesPerServing(recipe3Calories);
        recipe3.setFoodProducts(Arrays.asList(1L, 3L)); // Assuming 1L and 3L are valid food product IDs
        recipe3.setStatus(Status.APPROVED);

        Recipe recipe4 = new Recipe();
        recipe4.setChef_id("ujhLUcGPp3cujxTrkBjlW3nffEi2");
        recipe4.setDescription("Dinner desc");
        recipe4.setTitle("Dinner");
        recipe4.setCookingTime("40");
        CaloriesPerServing recipe4Calories = new CaloriesPerServing();
        recipe4Calories.setCarbs(7.1);
        recipe4Calories.setProtein(8.1);
        recipe4Calories.setFat(1.8);
        recipe4.setCaloriesPerServing(recipe4Calories);
        recipe4.setFoodProducts(Arrays.asList(1L, 2L,3L,4L)); // Assuming 1L and 3L are valid food product IDs
        recipe4.setStatus(Status.APPROVED);

        Recipe recipe5 = new Recipe();
        recipe5.setChef_id("ujhLUcGPp3cujxTrkBjlW3nffEi2");
        recipe5.setDescription("Lunch desc");
        recipe5.setTitle("Easy Lunch");
        CaloriesPerServing recipe5Calories = new CaloriesPerServing();
        recipe5Calories.setCarbs(2.1);
        recipe5Calories.setProtein(1.1);
        recipe5Calories.setFat(0.8);
        recipe5.setCaloriesPerServing(recipe5Calories);
        recipe5.setCookingTime("40");
        recipe5.setFoodProducts(Arrays.asList(1L, 2L, 4L));
        recipe5.setStatus(Status.PENDING);

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);
        recipeRepository.save(recipe4);
        recipeRepository.save(recipe5);
    }

}
