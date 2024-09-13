package org.example.recette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instruction")
    private int id;
    private String description;
    private int step;
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private Recipe recipe;


}
