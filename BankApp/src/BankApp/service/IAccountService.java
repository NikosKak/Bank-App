package BankApp.service;

import BankApp.core.exceptions.AccountNotFoundException;
import BankApp.core.exceptions.InsufficientBalanceException;
import BankApp.dto.AccountDepositDTO;
import BankApp.dto.AccountInsertDTO;
import BankApp.dto.AccountReadOnlyDTO;
import BankApp.dto.AccountWithdrawDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {
    AccountReadOnlyDTO createNewAccount(AccountInsertDTO insertDTO);
    void deposit(AccountDepositDTO depositDTO) throws AccountNotFoundException;
    void withdraw(AccountWithdrawDTO withdrawDTO) throws InsufficientBalanceException, AccountNotFoundException;
    BigDecimal getBalance(String iban) throws AccountNotFoundException;
    List<AccountReadOnlyDTO> getAllAccounts();
}