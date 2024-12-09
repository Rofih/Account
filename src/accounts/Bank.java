package accounts;

import java.util.ArrayList;

public class Bank {
    int counter = 0;
    private final ArrayList<Account> accounts = new ArrayList<>();
    String name = "bank";


    public Account createAccount(String firstName,String phoneNumber,String password) {
        Account account = new Account(firstName,phoneNumber,password);
        accounts.add(account);
        counter++;
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getNumberOfAccounts() {
        return counter;
    }
    public void deposit(String accountNumber, int amount) {
        Account account = searchForAccount(accountNumber);
        account.deposit(amount);
    }
    public int getBalance(String accountNumber,String password) {
        Account account = searchForAccount(accountNumber);
        return account.getBalance(password);
    }
    Account searchForAccount(String accountNumber) {
        for (Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }
    public int withdraw(String accountNumber,int amount, String password) {
        Account account = searchForAccount(accountNumber);
        account.withdrawAmount(amount, password);
        return amount;
    }
    public String getAccountNumber(Account account1) {
        return account1.getAccountNumber();
    }

    public void transfer(String accountNumber1,String accountNumber2, int amount, String number) {
        Account account = searchForAccount(accountNumber1);
        Account account2 = searchForAccount(accountNumber2);
        account.withdrawAmount(amount, number);
        account2.deposit(amount);
    }
    public void transfer2(Bank gtb,String accountNumber1,String accountNumber2, int amount, String number) {
        Account account = searchForAccount(accountNumber1);
        Account account2 = gtb.searchForAccount(accountNumber2);
        account.withdrawAmount(amount, number);
        account2.deposit(amount);
    }
//    public void transfer2(String bankName,String accountNumber1,String bankName2,String accountNumber2, int amount, String number) {
//        Account account = getBank(bankName).searchForAccount(accountNumber1);
//        Account account2 = getBank(bankName2).searchForAccount(accountNumber2);
//        account.withdrawAmount(amount, number);
//        account2.deposit(amount);
//    }

}
