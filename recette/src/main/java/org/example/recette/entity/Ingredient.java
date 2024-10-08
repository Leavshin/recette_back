package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.recette.utils.enums.Allergy;
import org.example.recette.utils.enums.IngredientCategory;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @Column(name = "id_ingredient")
    private int id;
    private String name;
    private String unit;
    private float calorie;
    private IngredientCategory ingredientCategory;

    @ElementCollection(targetClass = Allergy.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "ingredient_allergy", joinColumns = @JoinColumn(name = "id_ingredient"))
    @Column(name = "allergies")
    private List<Allergy> allergies = new ArrayList<>();

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<IngredientRecipe> recipes = new ArrayList<>();

    @Override
    public String toString() {
        return "Ingredient {id=" + id + ", name=" + name + ", calorie=" + calorie + "}";
    }

}
