package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.recette.utils.enums.Allergy;
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

    @ElementCollection(targetClass = Allergy.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "ingredient_allergy", joinColumns = @JoinColumn(name = "id_ingredient"))
    @Column(name = "allergies")
    private List<Allergy> allergies;

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<IngredientRecipe> recipes;

    @Override
    public String toString() {
        return "Ingredient {id=" + id + ", name=" + name + ", calorie=" + calorie + "}";
    }

}
