package BankApp.core.mapper;

import BankApp.dto.AccountInsertDTO;
import BankApp.dto.AccountReadOnlyDTO;
import BankApp.model.Account;

public class Mapper {

    /**
     * No instances of this class should be available.
     */
    private Mapper() {
    }

    public static Account mapToModelEntity(AccountInsertDTO dto) {
        return new Account(dto.iban(), dto.balance());
    }

    public static AccountReadOnlyDTO mapToReadOnlyDTO(Account account) {
        return new AccountReadOnlyDTO(account.getIban(), account.getBalance());
    }
}