package org.example.recette.service;

import org.example.recette.entity.Account;
import org.example.recette.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    public Account findAccountById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

}
