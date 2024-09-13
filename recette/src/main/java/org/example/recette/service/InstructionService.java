package org.example.recette.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.recette.entity.Instruction;
import org.example.recette.repository.InstructionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructionService {
    private final InstructionRepository instructionRepository;

    public InstructionService(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public Instruction createInstruction(Instruction instruction) {
        return instructionRepository.save(instruction);
    }

    public Instruction getInstructionById(int id) {
        return instructionRepository.findById(id).orElse(null);
    }

    public List<Instruction> getAllInstructionsFromRecipe(int recipeId) {
        return this.instructionRepository.findInstructionByRecipeId(recipeId);
    }

    public Instruction updateInstruction(Instruction instruction) {
        return instructionRepository.save(instruction);
    }

    public void deleteInstruction(int id) {
        instructionRepository.deleteById(id);
    }
}
