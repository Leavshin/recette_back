package org.example.recette.controller;

import org.example.recette.entity.Account;
import org.example.recette.entity.UserInventory;
import org.example.recette.service.AccountService;
import org.example.recette.service.UserInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class AccountController {

    private final AccountService accountService;
    private final UserInventoryService userInventoryService;

    public AccountController(AccountService accountService, UserInventoryService userInventoryService) {
        this.accountService = accountService;
        this.userInventoryService = userInventoryService;
    }

    @PostMapping("new")
    public ResponseEntity<Account> newAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("list")
    public ResponseEntity<List<Account>> listAccounts() {
        return ResponseEntity.ok(accountService.findAllAccounts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("addIngredients")
    public ResponseEntity<List<UserInventory>> addIngredients(@RequestBody List<UserInventory> userInventoryList) {
        for (UserInventory userInventory : userInventoryList) {
            userInventory = userInventoryService.create(userInventory);
        }
        return ResponseEntity.ok(userInventoryList);
    }

    @PostMapping("removeIngredients")
    public ResponseEntity<Void> removeIngredients(@RequestBody List<UserInventory> userInventoryList) {
        for (UserInventory userInventory : userInventoryList) {
            userInventoryService.delete(userInventory);
        }
        return ResponseEntity.noContent().build();
    }

}
