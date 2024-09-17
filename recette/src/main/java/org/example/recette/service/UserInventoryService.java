package org.example.recette.service;

import org.example.recette.entity.Account;
import org.example.recette.entity.Ingredient;
import org.example.recette.entity.UserInventory;
import org.example.recette.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInventoryService {

    private final UserInventoryRepository userInventoryRepository;

    public UserInventoryService(UserInventoryRepository userInventoryRepository) {
        this.userInventoryRepository = userInventoryRepository;
    }

    public UserInventory create(UserInventory userInventory) {
        return userInventoryRepository.save(userInventory);
    }
    public List<Ingredient> findByAccount (Account account) {
        List<UserInventory> userInventoryList = userInventoryRepository.findByAccount(account);
        List<Ingredient> ingredients = new ArrayList<>();
        for (UserInventory userInventory : userInventoryList) {
            ingredients.add(userInventory.getIngredient());
        }
        return ingredients;
    }

}
