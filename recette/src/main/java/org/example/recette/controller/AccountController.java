package org.example.recette.controller;

import org.example.recette.entity.Account;
import org.example.recette.entity.Ingredient;
import org.example.recette.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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

    @GetMapping("update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
        return ResponseEntity.ok(accountService.updateAccount(account));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
