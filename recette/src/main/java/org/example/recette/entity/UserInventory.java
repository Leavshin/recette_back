package org.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class UserInventory {
    @EmbeddedId
    private UserInventoryId id = new UserInventoryId();

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idInventory")
    @JoinColumn(name = "id_inventory")
    private Ingredient ingredient;

    @Override
    public String toString() {
        return "UserInventory {quantity=" + quantity + "}";
    }
}
