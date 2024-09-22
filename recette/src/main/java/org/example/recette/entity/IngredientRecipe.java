package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRecipe")
    @JoinColumn(name = "id_recipe")
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idIngredient")
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @Override
    public String toString() {
        return "IngredientRecipe {quantity=" + quantity + "}";
    }

}
