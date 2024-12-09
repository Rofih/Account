package accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void testThatICanDeposit() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(100);
        int result = account.getBalance("1234");
        int expected = 100;
        assertEquals(expected, result);
    }
    @Test
    public void testThatICanDepositTwice() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(100);
        account.deposit(100);
        int result = account.getBalance("1234");
        int expected = 200;
        assertEquals(expected, result);
    }
    @Test
    public void testThatICanNotDepositNegativeAmount() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(100);
        account.deposit(-100);
        int result = account.getBalance("1234");
        int expected = 100;
        assertEquals(expected, result);
    }
    @Test
    public void testThatICanWithdraw() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(200);
        account.withdrawAmount(100,"1234");
        int result = account.getBalance("1234");
        int expected = 100;
        assertEquals(expected, result);
    }
    @Test
    public void testThatICanNotWithdrawMoreThanBalance() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(200);
        account.withdrawAmount(300,"1234");
        int result = account.getBalance("1234");
        int expected = 200;
        assertEquals(expected, result);
    }
    @Test
    public void testThatICanNotWithdrawMoreNegativeAmount() {
        Account account = new Account("Rofih","09127461933","1234");
        account.deposit(200);
        account.withdrawAmount(-100,"1234");
        int result = account.getBalance("1234");
        int expected = 200;
        assertEquals(expected, result);
    }
}
