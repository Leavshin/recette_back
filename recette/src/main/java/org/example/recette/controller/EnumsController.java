package org.example.recette.controller;

import org.example.recette.utils.enums.Allergy;
import org.example.recette.utils.enums.IngredientCategory;
import org.example.recette.utils.enums.Preference;
import org.example.recette.utils.enums.RecipeCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enum/")
public class EnumsController {

    @GetMapping("allergy")
    public List<String> allergy() {
        return Arrays.stream(Allergy.values()).map(Enum::name).collect(Collectors.toList());
    }

    @GetMapping("recipe_category")
    public List<String> recipeCategory() {
        return Arrays.stream(RecipeCategory.values()).map(Enum::name).collect(Collectors.toList());
    }

    @GetMapping("preference")
    public List<String> preference() {
        return Arrays.stream(Preference.values()).map(Enum::name).collect(Collectors.toList());
    }
}
