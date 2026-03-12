package BankApp.dao;
import BankApp.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountDAO {
    Account saveOrUpdate(Account account);
    void remove(String iban);
    Optional<Account> findByIban(String iban);
    List<Account> getAllAccounts();
    long count();

    // Queries
    boolean isAccountExists(String iban);
}