package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class IngredientRecipeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    @JsonBackReference
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "id_recipe")
    @JsonBackReference
    private Recipe recipe;

    @Override
    public String toString() {
        return "IngredientId=" + ingredient.getId() + ", RecipeId=" + recipe.getId();
    }

}
