package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.recette.utils.enums.RecipeCategory;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private int id;
    private String name;
    private String description;
    private int portion;
    private String imageUrl;
    private LocalTime prepTime;
    private LocalTime cookTime;
    private RecipeCategory category;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Instruction> instructions;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<IngredientRecipe> ingredients;

    @Override
    public String toString() {
        return "Recipe {id=" + id + ", name=" + name + ", portion=" + portion + "}";
    }
}
