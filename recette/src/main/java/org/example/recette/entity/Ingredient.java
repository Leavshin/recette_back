package org.example.recette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.recette.utils.enums.IngredientCategory;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @Column(name = "id_ingredient")
    private String id;
    private String name;
    private String unit;
    private String calorie;
    private IngredientCategory ingredientCategory;

    @ManyToMany
    private List<Allergy> allergies;

    @OneToMany(mappedBy = "ingredient")
    private List<IngredientRecipe> recipes;

}
