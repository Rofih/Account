package accounts;

import java.util.ArrayList;


public class PayStack {
    ArrayList<Bank> banks = new ArrayList<>();

    public void addBank(Bank bank) {
        banks.add(bank);
    }
    public Bank getBank(String name) {
        for (int count = 0; count < banks.size(); count++) {
            if(banks.get(count).getName().equals(name)) {
                return banks.get(count);
            }
        }
        return null;
    }
    public void transfer(String bankName,String accountNumber1,String bankName2,String accountNumber2, int amount, String number) {
        Account account = getBank(bankName).searchForAccount(accountNumber1);
        Account account2 = getBank(bankName2).searchForAccount(accountNumber2);
        account.withdrawAmount(amount, number);
        account2.deposit(amount);
    }
}
