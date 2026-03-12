package BankApp.controller;
import BankApp.core.exceptions.AccountNotFoundException;
import BankApp.core.exceptions.InsufficientBalanceException;
import BankApp.core.exceptions.ValidationException;
import BankApp.dto.AccountDepositDTO;
import BankApp.dto.AccountInsertDTO;
import BankApp.dto.AccountReadOnlyDTO;
import BankApp.dto.AccountWithdrawDTO;
import BankApp.service.IAccountService;
import BankApp.validation.Validator;
import BankApp.dao.IAccountDAO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class AccountController {
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public AccountReadOnlyDTO createNewAccount(String iban, BigDecimal balance)
            throws ValidationException {
        AccountReadOnlyDTO readOnlyDTO;
        AccountInsertDTO insertDTO = new AccountInsertDTO(iban, balance);

        // Validation
        Map<String, String> errors;
        errors = Validator.validateInsertDTO(insertDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        // Proceed to service
        readOnlyDTO = accountService.createNewAccount(insertDTO);
        return readOnlyDTO;
    }

    public void deposit(String iban, BigDecimal amount)
            throws AccountNotFoundException, ValidationException {

        AccountDepositDTO depositDTO = new AccountDepositDTO(iban, amount);

        Map<String, String> errors;
        errors = Validator.validateDepositDTO(depositDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        accountService.deposit(depositDTO);
    }

    public void withdraw(String iban, BigDecimal amount)
            throws AccountNotFoundException, ValidationException, InsufficientBalanceException {

        AccountWithdrawDTO withdrawDTO = new AccountWithdrawDTO(iban, amount);

        // Validation
        Map<String, String> errors;
        errors = Validator.validateWithdrawDTO(withdrawDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        accountService.withdraw(withdrawDTO);
    }

    public BigDecimal getBalance(String iban)
            throws AccountNotFoundException, ValidationException {

        // Validation
        Map<String, String> errors;
        errors = Validator.validateIban(iban);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        return accountService.getBalance(iban);
    }

    public List<AccountReadOnlyDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}