package org.example.recette.service;

import org.example.recette.entity.Account;
import org.example.recette.entity.Ingredient;
import org.example.recette.entity.IngredientRecipe;
import org.example.recette.entity.Recipe;
import org.example.recette.repository.IngredientRecipeRepository;
import org.example.recette.repository.RecipeRepository;
import org.example.recette.utils.enums.Allergy;
import org.example.recette.utils.enums.Preference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final InstructionService instructionService;
    private final IngredientRecipeRepository ingredientRecipeRepository;
    private final UserInventoryService userInventoryService;
    private final AccountService accountService;

    public RecipeService(RecipeRepository recipeRepository, InstructionService instructionService, IngredientRecipeRepository ingredientRecipeRepository, UserInventoryService userInventoryService, AccountService accountService) {
        this.recipeRepository = recipeRepository;
        this.instructionService = instructionService;
        this.ingredientRecipeRepository = ingredientRecipeRepository;
        this.userInventoryService = userInventoryService;
        this.accountService = accountService;
    }

    public Recipe createRecipe(Recipe recipe) {
        Recipe newRecipe = recipeRepository.save(recipe);
        for (IngredientRecipe ingredient : recipe.getIngredients()) {
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
        for (IngredientRecipe ingredientRecipe : ingredientRecipes) {
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


    public List<Recipe> findRecipeByIngredient(Account account) {

        List<Ingredient> ingredients = userInventoryService.findByAccount(account);
        List<Recipe> result = new ArrayList<>();
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        for (Recipe recipe : recipes) {
            boolean notFound = false;
            for (IngredientRecipe ingredient : recipe.getIngredients()) {
                System.out.println(recipe.getIngredients());
                if (!ingredients.contains(ingredient.getIngredient())) {
                    notFound = true;
                }
            }
            if (!notFound) {
                result.add(recipe);
            }
        }
        return result;
    }

    public List<Recipe> findRecipeByPreference(Preference preference) {
        List<Recipe> recipes;
        if("AUCUNE".equals(preference.name())) {
            recipes = findAllRecipes();
        } else {
            recipes= recipeRepository.findRecipesByPreferencesContaining(preference);
        }
        return recipes;
    }

    public List<Recipe> findRecipeByAccountAllergies(int idAccount) {
        Account account = accountService.findAccountById(idAccount);
        List<Recipe> recipes = findRecipeByPreference(account.getPreference());
        List<Allergy> allergies = account.getAllergies();
        List<Recipe> result = new ArrayList<>();
        for(Recipe recipe : recipes) {
            boolean found = false;
            for(IngredientRecipe ingredient : recipe.getIngredients()) {
                // Vérifie si un ingrédient de la recette possède une allergie de l'utilisateur
                boolean containsAnyAllergy = allergies.stream().anyMatch(allergy -> ingredient.getIngredient().getAllergies().contains(allergy));
                if(!allergies.isEmpty() && !ingredient.getIngredient().getAllergies().isEmpty() && containsAnyAllergy) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                result.add(recipe);
            }
        }
        return result;
    }
}
