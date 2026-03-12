package BankApp.validation;

import BankApp.dto.AccountDepositDTO;
import BankApp.dto.AccountInsertDTO;
import BankApp.dto.AccountWithdrawDTO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    private Validator() {

    }

    public static Map<String, String> validateInsertDTO(AccountInsertDTO insertDTO) {
        Map<String, String> errors = new HashMap<>();

        if (insertDTO.iban() == null || !insertDTO.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρέπει να ξεκινάει με GR και να ακολουθείται από 3-25 ψηφία.");
        }

        if (insertDTO.balance() == null || insertDTO.balance().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("balance", "Το υπόλοιπο δεν μπορεί να είναι αρνητικό.");
        }

        return errors;
    }

    public static Map<String, String> validateDepositDTO(AccountDepositDTO depositDTO) {
        Map<String, String> errors = new HashMap<>();

        if (depositDTO.iban() == null || !depositDTO.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρέπει να ξεκινάει με GR και να ακολουθείται από 3-25 ψηφία.");
        }

        if (depositDTO.amount() == null || depositDTO.amount().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("amount", "Το ποσό κατάθεσης δεν μπορεί να είναι αρνητικό.");
        }

        return errors;
    }

    public static Map<String, String> validateWithdrawDTO(AccountWithdrawDTO withdrawDTO) {
        Map<String, String> errors = new HashMap<>();

        if (withdrawDTO.iban() == null || !withdrawDTO.iban().trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρέπει να ξεκινάει με GR και να ακολουθείται από 3-25 ψηφία.");
        }

        if (withdrawDTO.amount() == null || withdrawDTO.amount().compareTo(BigDecimal.ZERO) < 0) {
            errors.put("amount", "Το ποσό ανάληψης δεν μπορεί να είναι αρνητικό.");
        }

        return errors;
    }

    public static Map<String, String> validateIban(String iban) {
        Map<String, String> errors = new HashMap<>();

        if (iban == null || !iban.trim().matches("GR\\d{3,25}")) {
            errors.put("iban", "Το iban πρέπει να ξεκινάει με GR και να ακολουθείται από 3-25 ψηφία.");
        }
        return errors;
    }

}