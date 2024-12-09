package accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayStackTest {

    @Test
    public void testThatICanAddBanks() {
        PayStack cbn = new PayStack();
        Bank gtb = new Bank();
        gtb.setName("GTB");
        cbn.addBank(gtb);
        Bank wema = new Bank();
        wema.setName("Wema");
        cbn.addBank(wema);
        assertEquals(cbn.getBank("GTB"), gtb);
        assertEquals(cbn.getBank("Wema"), wema);
    }

    @Test
    public void testThatICanTransferFromOneBankAccountToAnotherBankAccount() {
        PayStack cbn = new PayStack();
        Bank gtb = new Bank();
        gtb.setName("gtb");
        cbn.addBank(gtb);
        Bank wema = new Bank();
        wema.setName("wema");
        cbn.addBank(wema);
        gtb.createAccount("Jomiloju","08025823727","1234");
        gtb.deposit("08025823727",2000);
        wema.createAccount("Victor","09127461933","1234");
        cbn.transfer("gtb","08025823727","wema","09127461933",1000,"1234");
        assertEquals(1000,gtb.getBalance("08025823727","1234"));
        assertEquals(1000,wema.getBalance("09127461933","1234"));
    }
}
