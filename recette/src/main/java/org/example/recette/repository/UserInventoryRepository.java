package org.example.recette.repository;

import org.example.recette.entity.Account;
import org.example.recette.entity.Ingredient;
import org.example.recette.entity.UserInventory;
import org.example.recette.entity.UserInventoryId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInventoryRepository extends CrudRepository<UserInventory, UserInventoryId> {
    List<UserInventory> findByAccount(Account account);
    UserInventory findByAccountAndIngredient(Account account, Ingredient ingredient);
}
