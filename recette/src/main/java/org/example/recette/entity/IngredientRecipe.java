package org.example.recette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRecipe {

    @EmbeddedId
    private IngredientRecipeId id = new IngredientRecipeId();

    private int quantity;

    @Override
    public String toString() {
        return "IngredientRecipe {quantity=" + quantity + "}";
    }

}
