package accounts;

public class Account {
    private int balance = 0;
    private String password = "";
    private String name = "";
    private String number="";

    public Account(String name,String number,String password) {
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public int getBalance(String password) {
        boolean result = verifyPassword(password);
        if (!result) {
            throw new IllegalArgumentException("Invalid password");
        }
        return balance;
    }

    public void withdrawAmount(int amount,String password) {
        boolean result = verifyPassword(password);
        if (result) {
            if (amount > 0) {
                if (balance > amount) {
                    balance -= amount;
                }
            }
        }
    }

    public String getNumber() {
        return number;
    }

    private boolean verifyPassword(String password) {
        if(this.password == password) {
            return true;
        }
        else{
            return false;
        }
    }

    private void generateAccountNumber() {
         number = number.substring(1);
    }

    public String getAccountNumber() {

        return number;

    }
}

