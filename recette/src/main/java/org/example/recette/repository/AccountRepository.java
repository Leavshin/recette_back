package org.example.recette.repository;

import org.example.recette.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findAccountByEmail(String email);
    Account findAccountByEmailAndPassword(String email, String password);
}
