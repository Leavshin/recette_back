package org.example.recette.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class IngredientRecipeId implements Serializable {
    private String idIngredient;
    private int idRecipe;
}
