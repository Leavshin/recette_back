package org.example.recette.service;

import org.example.recette.dto.AccountDTO;
import org.example.recette.entity.*;
import org.example.recette.repository.AccountRepository;
import org.example.recette.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserInventoryRepository userInventoryRepository;
    private final RecipeService recipeService;

    public AccountService(AccountRepository accountRepository, UserInventoryRepository userInventoryRepository, RecipeService recipeService) {
        this.accountRepository = accountRepository;
        this.userInventoryRepository = userInventoryRepository;
        this.recipeService = recipeService;
    }

    public Account createAccount(Account account) {
        Account newAccount = accountRepository.save(account);
        for(UserInventory userInventory : newAccount.getInventories()) {
            userInventory.setAccount(newAccount);
            userInventoryRepository.save(userInventory);
        }
        return newAccount;
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(int id) {
        List<UserInventory> userInventories = userInventoryRepository.findByAccount(findAccountById(id));
        for(UserInventory userInventory : userInventories) {
            userInventoryRepository.delete(userInventory);
        }
        accountRepository.deleteById(id);
    }

    public Account findAccountById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public Account findAccountByEmailAndPassword(String email, String password) {
        return accountRepository.findAccountByEmailAndPassword(email, password);
    }

    private boolean checkRecipeIsInAccount(Recipe recipe, Account account) {
        return account.getFavoriteRecipes().contains(recipe);
    }
    public void addRecipeToFavorite(int idRecipe, int idAccount) {
        Recipe recipeToAdd = recipeService.findRecipeById(idRecipe);
        Account account = accountRepository.findById(idAccount).orElse(null);
        if(recipeToAdd != null && account != null && !checkRecipeIsInAccount(recipeToAdd, account)) {
            account.getFavoriteRecipes().add(recipeToAdd);
            accountRepository.save(account);
        }
    }
    public void removeRecipeFromFavorite(int idRecipe, int idAccount) {
        Recipe recipeToRemove = recipeService.findRecipeById(idRecipe);
        Account account = accountRepository.findById(idAccount).orElse(null);
        if(recipeToRemove != null && account != null && checkRecipeIsInAccount(recipeToRemove, account)) {
            account.getFavoriteRecipes().remove(recipeToRemove);
            accountRepository.save(account);
        }
    }

}
