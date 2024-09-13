package org.example.recette.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class IngredientRecipeId implements Serializable {

    @Column(name = "id_ingredient")
    private String idIngredient;

    @Column(name = "id_recipe")
    private int idRecipe;



}
