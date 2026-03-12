package BankApp.dto;
import java.math.BigDecimal;

public record AccountInsertDTO(String iban, BigDecimal balance) {

    //
    public static AccountInsertDTO empty() {
        return new AccountInsertDTO("", BigDecimal.ZERO);
    }
}