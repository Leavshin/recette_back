package org.example.recette.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private int id;
    private String name;
    private String password;
    private String email;
    private boolean isAdmin;

    @ManyToMany
    private List<Recipe> favoriteRecipes;

    @ManyToMany
    private List<Allergy> allergies;

}
