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

    public AccountService(AccountRepository accountRepository, UserInventoryRepository userInventoryRepository) {
        this.accountRepository = accountRepository;
        this.userInventoryRepository = userInventoryRepository;
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


    public Account findAccountByEmailAndPassword(String email, String password) {
        return accountRepository.findAccountByEmailAndPassword(email, password);
    }

    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

}
