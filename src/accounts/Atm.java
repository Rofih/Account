package accounts;

import java.util.Scanner;

public class Atm {
    static Bank bank = new Bank();
    public static void main(String[] args) {
         goToMainMenu();
       // output(String.format(checkBalanceOf()));
    }
    public  static void goToMainMenu(){

        String menu = """
                1-> Create account.
                2-> Deposit into an account.
                3-> Withdraw from the account.
                4-> Transfer into an account.
                5-> Check balance.
                6-> exit app.
                
                """;
        output(menu);

        String message =  input("pls enter a number: ");
        switch (message) {
            case "1":createAccount();break;
            case "2":depositTo();break;
            case "3":withdrawFrom();break;
            case "4":transferTo();break;
            case "5":checkBalanceOf();break;
            case "6":interTransferTo();break;
//            case "7":;exitApp();break;
        }


    }
    private  static String input(String input){
        System.out.println(input);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
//    private  static Bank input(String input){
//        System.out.println(input);
//        Scanner scanner = new Scanner(System.in);
//        return scanner.next();
//
//    }
    private static void output(String output){
        System.out.println(output);
    }

    public static void createAccount(String name, String number, String password){
        Account account = bank.createAccount(name, number, password);
    }
    public static void deposit(String accountNumber, int amount){
        bank.deposit(accountNumber,amount);
    }
    public static void withdraw(String accountNumber, int amount, String password){
        int money = bank.withdraw(accountNumber,amount,password);
        output(String.format("amount transferred is: %d",money));
    }
    public static void transfer(String accountNumber, String toAccountNumber, int amount, String password){
        bank.transfer(accountNumber,toAccountNumber,amount,password);
    }
    public static void transferToAnotherBank(Bank gtb,String accountNumber, String toAccountNumber, int amount, String password){
        bank.transfer2(gtb,accountNumber, toAccountNumber, amount, password);
    }
    public static void checkBalance(String accountNumber, String password){
        int amount = bank.getBalance(accountNumber,password);
        output(String.format("Account balance is: %d", amount));
    }


    private static void createAccount() {
        String name = input("Enter your name: ");
        String number = input("Enter your number: ");
        String password = input("Enter your password: ");
        createAccount(name,number,password);

        goToMainMenu();
    }

    private static void depositTo() {
        String accountNumber = input("Enter your account number: ");
        int amount = Integer.parseInt(input("Enter your amount"));
        deposit(accountNumber,amount);
        goToMainMenu();
    }

    private static void withdrawFrom() {
        String accountNumber = input("Enter your account number: ");
        int amount = Integer.parseInt(input("Enter your amount"));
        String password = input("Enter your password: ");
        withdraw(accountNumber,amount,password);
        goToMainMenu();
    }

    private static void transferTo() {
        String accountNumber = input("Enter your account number: ");
        int amount = Integer.parseInt(input("Enter your amount"));
        String toAccountNumber = input("Enter your account number: ");
        String password = input("Enter your password: ");
        transfer(accountNumber,toAccountNumber,amount,password);
        goToMainMenu();
    }

    private static void interTransferTo() {
        String accountNumber = input("Enter your account number: ");
        int amount = Integer.parseInt(input("Enter your amount"));
        String toAccountNumber = input("Enter your account number: ");
//        Bank gtb =(Bank) input("Enter bank name: ");
        String password = input("Enter your password: ");
        Bank gtb = bank;
        transferToAnotherBank(gtb,accountNumber,toAccountNumber,amount,password);
        goToMainMenu();
    }


    private static void checkBalanceOf() {
        String accountNumber = input("Enter your account number: ");
        String password = input("Enter your password: ");
        checkBalance(accountNumber,password);
        goToMainMenu();
    }
}
