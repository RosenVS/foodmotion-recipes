package com.individual.foodmotionrecipes.repository;

import com.individual.foodmotionrecipes.model.Recipe;
import com.individual.foodmotionrecipes.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE r.chef_id = :chefId")
    List<Recipe> findByChefId(@Param("chefId") String chefId);

    @Query("SELECT r FROM Recipe r WHERE r.status = :status")
    List<Recipe> findByStatus(@Param("status") Status status);
}


