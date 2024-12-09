package accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    @Test
    public void  test_That_I_Can_Create_an_Account() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Rofih","09127461933", "1234");
        assertEquals(1,bank.getNumberOfAccounts());
    }
    @Test
    public void  test_That_I_Can_deposit_Into_an_Account() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Rofih","09127461933", "1234");
        String accountNumber = bank.getAccountNumber(account);
        bank.deposit(accountNumber,10_000);
        assertEquals(10_000,bank.getBalance(accountNumber,"1234"));
    }
    @Test
    public void  test_That_I_Can_Withdraw_from_an_Account() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Rofih","09127461933", "1234");
        String accountNumber = bank.getAccountNumber(account);
        bank.deposit(accountNumber,10_000);
        assertEquals(10_000,bank.getBalance(accountNumber,"1234"));
        int amount = 5_000;
        int withdrawnAmount = bank.withdraw(accountNumber,amount,"1234");
        assertEquals(5_000,bank.getBalance(accountNumber,"1234"));
    }
    @Test
    public void test_that_I_can_transfer_from_an_Account() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Rofih","09127461933", "1234");
        String accountNumber = bank.getAccountNumber(account);
        bank.deposit(accountNumber,20_000);
        assertEquals(20_000,bank.getBalance(accountNumber,"1234"));
        Account account2 = bank.createAccount("Oladimeji","09127461934","1234");
        String accountNumber2 = bank.getAccountNumber(account2);
        assertEquals(0,bank.getBalance(accountNumber2,"1234"));
        bank.transfer(accountNumber,accountNumber2,10_000,"1234");
        assertEquals(10_000, bank.getBalance(accountNumber2,"1234"));
        assertEquals(10_000,bank.getBalance(accountNumber,"1234"));
    }

    @Test
    public void test_that_I_can_transfer_from_a_bankAccount_to_another_bankAccount() {
        Bank bank = new Bank();
        Account account = bank.createAccount("Rofih","09127461933", "1234");
        String accountNumber = bank.getAccountNumber(account);
        bank.deposit(accountNumber,20_000);
        assertEquals(20_000,bank.getBalance(accountNumber,"1234"));
        Account account2 = bank.createAccount("Oladimeji","09127461934","1234");
        String accountNumber2 = bank.getAccountNumber(account2);
        assertEquals(0,bank.getBalance(accountNumber2,"1234"));
        Bank bank2 = new Bank();
        Account bankAccount = bank2.createAccount("Ayomide","09127461933", "1234");
        bank.transfer2(bank2,accountNumber,"09127461933",10_000,"1234");
        assertEquals(10_000, bank.getBalance("09127461933" ,"1234"));
        assertEquals(10_000,bank.getBalance(accountNumber,"1234"));
    }
//    @Test
//    public void test_that_I_can_not_transfer_Into_a_wrong_Account() {
//        Bank bank = new Bank();
//        Account account = bank.createAccount("Rofih","09127461933", "1234");
//        String accountNumber = bank.getAccountNumber(account);
//        bank.deposit(accountNumber,10_000);
//        Bank bank2 = new Bank();
//        Account account2 = bank2.createAccount("Oladimeji","09127461933","1234");
//        String accountNumber2 = bank.getAccountNumber(account2);
//        assertEquals(0,bank2.getBalance(accountNumber2,"1234"));
//        int amount = 10_000;
//        String wrongAccountNumber = "8023353223";
//        assertThrows(IllegalArgumentException.class, ()-> bank.transfer(accountNumber,wrongAccountNumber,amount,"1234");
//    }
}
