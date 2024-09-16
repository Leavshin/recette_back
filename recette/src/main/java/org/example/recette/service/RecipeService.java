package org.example.recette.service;

import org.example.recette.entity.Ingredient;
import org.example.recette.entity.IngredientRecipe;
import org.example.recette.entity.Recipe;
import org.example.recette.repository.IngredientRecipeRepository;
import org.example.recette.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final InstructionService instructionService;
    private final IngredientRecipeRepository ingredientRecipeRepository;

    public RecipeService(RecipeRepository recipeRepository, InstructionService instructionService, IngredientRecipeRepository ingredientRecipeRepository) {
        this.recipeRepository = recipeRepository;
        this.instructionService = instructionService;
        this.ingredientRecipeRepository = ingredientRecipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        Recipe newRecipe = recipeRepository.save(recipe);
        for(IngredientRecipe ingredient : recipe.getIngredients()) {
            ingredient.setRecipe(newRecipe);
            ingredientRecipeRepository.save(ingredient);
        }
        return newRecipe;
    }
    public Recipe updateRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        List<IngredientRecipe> ingredientRecipes = ingredientRecipeRepository.findByRecipe(findRecipeById(id));
        for(IngredientRecipe ingredientRecipe : ingredientRecipes) {
            ingredientRecipeRepository.delete(ingredientRecipe);
        }
        this.recipeRepository.deleteById(id);
    }

    public Recipe findRecipeById(int id) {
        Recipe recipe = this.recipeRepository.findById(id).orElse(null);
        if (recipe == null) {
            return null;
        } else {
            recipe.setInstructions(this.instructionService.findAllInstructionsFromRecipe(recipe.getId()));
        }
        return recipe;
    }

    public List<Recipe> findAllRecipes() {
        return (List<Recipe>) this.recipeRepository.findAll();
    }

}
