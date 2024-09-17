package org.example.recette.repository;

import org.example.recette.entity.Recipe;
import org.example.recette.utils.enums.Preference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.prefs.Preferences;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findRecipesByPreferencesContaining(Preference preference);
}
