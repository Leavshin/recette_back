package org.example.recette.service;

import org.example.recette.entity.Instruction;
import org.example.recette.entity.Recipe;
import org.example.recette.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final InstructionService instructionService;

    public RecipeService(RecipeRepository recipeRepository, InstructionService instructionService) {
        this.recipeRepository = recipeRepository;
        this.instructionService = instructionService;
    }

    public Recipe createRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }
    public Recipe updateRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        this.recipeRepository.deleteById(id);
    }

    public Recipe getRecipeById(int id) {
        return this.recipeRepository.findById(id).orElse(null);
    }
    public List<Recipe> getAllRecipe() {
        return (List<Recipe>) this.recipeRepository.findAll();
    }

    public List<Instruction> getAllInstructionsFromRecipeId(int id) {
        return this.instructionService.getAllInstructionsFromRecipe(id);
    }
}
