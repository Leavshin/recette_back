package org.example.recette.repository;

import org.example.recette.entity.IngredientRecipe;
import org.example.recette.entity.IngredientRecipeId;
import org.example.recette.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRecipeRepository extends CrudRepository<IngredientRecipe, IngredientRecipeId> {
    List<IngredientRecipe> findByRecipe(Recipe recipe);
}
