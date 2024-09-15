package org.example.recette.controller;

import org.example.recette.entity.Ingredient;
import org.example.recette.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient/")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("list")
    public ResponseEntity<List<Ingredient>> listIngredients() {
        return ResponseEntity.ok(ingredientService.findAllIngredients());
    }

    @PostMapping("new")
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.createIngredient(ingredient));
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") String id) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") String id, @RequestBody Ingredient updatedIngredient) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientService.updateIngredient(updatedIngredient));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") String id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }


}
