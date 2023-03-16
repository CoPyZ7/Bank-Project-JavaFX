package com.example.bankproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Accounts {
    protected long accountNumber;
    protected String accountName;
    protected double accountBalance;


    //getters
    public double getAccountBalance(){
        return accountBalance;
    }
    public String getAccountName(){
        return accountName;
    }

    //setters
    public void changeAccountBalance(double amount) {
        this.accountBalance += amount;
    }


    // no input constructor
    public Accounts(){}
    // constructor to create new accounts
    public Accounts(long accountNumber, String accountName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    // calculates the total balance of all accounts, takes an ArrayList of type Accounts
    public static double getTotalBalance(ArrayList<Accounts> acc) {
        double tot = 0;
        //iterates through the list and gets accountBalance for each item and adds it to tot.
        for(Accounts a : acc) {
            tot = tot + a.getAccountBalance();
        }
        return tot;
    }

    //prints all accounts, takes an ArrayList with type Accounts
    public static void printAllAccounts(ArrayList<Accounts> acc){
        //iterates through array list and enacts toString() method
        for(Accounts a : acc) {
            System.out.println(a.toString());
        }
    }
    //transfer money between accounts
    public static void makeTransfer(ArrayList<Accounts> acc) {
        Scanner userInput = new Scanner(System.in);

        printAllAccounts(acc);

        try{
            System.out.println("From what account?: ");
            int from = userInput.nextInt();
            Accounts fromAccount = acc.get(from);

            System.out.println("To what account?: ");
            int to = userInput.nextInt();
            Accounts toAccount = acc.get(to);

            System.out.println("Amount to transfer?: ");
            double amount = userInput.nextDouble();

            if(fromAccount.getAccountBalance() < amount){
                System.out.println("Insufficient funds");
            }
            else{
                toAccount.changeAccountBalance(amount);
                fromAccount.changeAccountBalance(amount = -amount);
            }
        }
        catch(InputMismatchException e){
            System.out.println("Bad input.");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error, Account doesnt exit.");
        }

    }
    // returns the balance of an account as a string
    public String balanceToString() {
        return String.valueOf(accountBalance);
    }

    @Override
    public String toString() {
        return "Account Name: " + accountName
                + "\n------------------------------------"
                + "\nAccount Number: " + accountNumber
                + "\nAccount Balance: " + accountBalance + "\n";
    }
}
