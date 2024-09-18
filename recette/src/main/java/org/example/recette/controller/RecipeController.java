package org.example.recette.controller;

import org.example.recette.entity.Recipe;
import org.example.recette.service.AccountService;
import org.example.recette.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe/")
public class RecipeController {
    private final RecipeService recipeService;
    private final AccountService accountService;

    public RecipeController(RecipeService recipeService, AccountService accountService) {
        this.recipeService = recipeService;
        this.accountService = accountService;
    }

    @GetMapping("list")
    public ResponseEntity<List<Recipe>> listRecipes() {
        return ResponseEntity.ok(recipeService.findAllRecipes());
    }

    @PostMapping("new")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.createRecipe(recipe));
    }

    @GetMapping("{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") int id) {
        Recipe recipe = recipeService.findRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe updatedRecipe) {
        Recipe recipe = recipeService.findRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeService.updateRecipe(updatedRecipe));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("list_by_inventory")
    public ResponseEntity<List<Recipe>> listRecipeByInventory(@RequestBody int id) {
      return ResponseEntity.ok(recipeService.findRecipeByIngredient(accountService.findAccountById(id)));
    }

    @GetMapping("list_by_pref_and_allergy")
    public ResponseEntity<List<Recipe>> listRecipeByAccountPrefAndAllergy(@RequestBody int id) {
        return ResponseEntity.ok(recipeService.findRecipeByAccountAllergies(id));
    }

}
