package org.example.recette.service;

import org.example.recette.dto.AccountDTO;
import org.example.recette.entity.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {
    private final AccountService accountService;

    public AuthService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean register(AccountDTO accountDTO) {
        Account user = accountService.findAccountByEmail(accountDTO.getEmail());
        if (user != null) {
            return false;
        } else {
            user = convertToAccount(accountDTO);
            accountService.createAccount(user);
        }
        return true;
    }

    public boolean login(AccountDTO accountDTO) {
        System.out.println(accountDTO);
        Account user = accountService.findAccountByEmailAndPassword(accountDTO.getEmail(), accountDTO.getPassword());
        System.out.println(user);
        return user != null;
    }

    private Account convertToAccount(AccountDTO accountDTO) {
        Account account = Account.builder()
                .email(accountDTO.getEmail())
                .password(accountDTO.getPassword())
                .allergies(new ArrayList<>())
                .favoriteRecipes(new ArrayList<>())
                .inventories(new ArrayList<>())
                .build();
        return account;
    }

}
