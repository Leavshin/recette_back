package org.example.recette.repository;

import org.example.recette.entity.Instruction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionRepository extends CrudRepository<Instruction, Integer> {
    List<Instruction> findInstructionByRecipeId(int recipeId);
}
