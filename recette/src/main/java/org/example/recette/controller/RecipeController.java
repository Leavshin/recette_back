package org.example.recette.controller;

import org.example.recette.entity.Instruction;
import org.example.recette.entity.Recipe;
import org.example.recette.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }

    @PostMapping("new")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.createRecipe(recipe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable("id") int id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") int id, @RequestBody Recipe updatedRecipe) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipeService.updateRecipe(updatedRecipe));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/instructions")
    public ResponseEntity<List<Instruction>> getInstructionsFromRecipeId(@PathVariable("id") int id) {
        return ResponseEntity.ok(recipeService.getAllInstructionsFromRecipeId(id));
    }
}
