package org.example.recette.service;

import org.example.recette.entity.Allergy;
import org.example.recette.repository.AllergyRepository;

import java.util.List;

public class AllergyService {

    private AllergyRepository allergyRepository;

    public AllergyService(AllergyRepository allergyRepository) {
        this.allergyRepository = allergyRepository;
    }

    public Allergy createAllergy(Allergy allergy) {
        return allergyRepository.save(allergy);
    }

    public Allergy updateAllergy(Allergy allergy) {
        return allergyRepository.save(allergy);
    }

    public void deleteAllergy(int id){
        allergyRepository.deleteById(id);
    }

    public Allergy findAllergyById(int id) {
        return allergyRepository.findById(id).orElse(null);
    }

    public List<Allergy> findAllAllergies() {
        return (List<Allergy>) allergyRepository.findAll();
    }
}
