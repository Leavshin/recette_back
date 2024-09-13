package org.example.recette.repository;

import org.example.recette.entity.Allergy;
import org.springframework.data.repository.CrudRepository;

public interface AllergyRepository extends CrudRepository<Allergy, Integer> {
}
