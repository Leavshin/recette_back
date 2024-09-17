package org.example.recette.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.recette.utils.enums.Allergy;
import org.example.recette.utils.enums.Preference;

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

    @ElementCollection(targetClass = Allergy.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "account_allergy", joinColumns = @JoinColumn(name = "id_account"))
    @Column(name = "allergies")
    private List<Allergy> allergies;

    @Enumerated(EnumType.STRING)
    private Preference preference;

}
