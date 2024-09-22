package org.example.recette.service;

import org.example.recette.entity.Ingredient;
import org.example.recette.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }
    public Ingredient updateIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(int id) {
        this.ingredientRepository.deleteById(id);
    }

    public Ingredient findIngredientById(int id) {
        return this.ingredientRepository.findById(id).orElse(null);
    }
    public List<Ingredient> findAllIngredients() {
        return (List<Ingredient>) this.ingredientRepository.findAll();
    }

}
