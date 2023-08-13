package com.abc.classes;

import java.util.ArrayList;
import java.util.List;

import com.abc.classes.Account.AccountType;
import com.abc.helpers.CustomerStatementBuilder;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    public Account openAccount(AccountType accountType) {
        Account newAccount = new Account(accountType);
        accounts.add(newAccount);
        return newAccount;
    } 
    
    //Getters//
    public Customer getCustomer(){
        return this;
    }
    
    public String getName() {
        return name;
    }

    public List<Account> getAccounts(){
        return accounts;
    }
      
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double getTotalInterestEarned() {
        double total = 0;
        try{
        for (Account a : accounts)
            total += a.getAccruedInterest();
        return total;
        }
        catch(NullPointerException e){
            System.out.println("No customers found");
            e.printStackTrace();
            return total;
        }
    }

    public static String getAccountStatement(Account account){
        String statement = CustomerStatementBuilder.createStatement(account);
        return statement;
    }
    
    public static List<String> getAllAccountStatements(){
        List<String> accountStatements = new ArrayList<>();
        accountStatements = CustomerStatementBuilder.createStatement(accounts);

        return accountStatements;
    }

    

   

        //Remove after testing
    public static void main(String[] args) {
        Customer customer = new Customer("Test Name");
        Account newAccount = customer.openAccount(AccountType.CHECKING);
        Account newAccount1 = customer.openAccount(AccountType.MAXI_SAVINGS);
        Account newAccount2 = customer.openAccount(AccountType.MAXI_SAVINGS);
        newAccount.tryDeposit(5000);
        newAccount.addInterest();
        newAccount.addInterest();

        // System.out.println(customer.getNumberOfAccounts());
        // System.out.println(newAccount.getBalance());
        // System.out.println(customer.totalInterestEarned());
        System.out.println(getAccountStatement(newAccount));
        System.out.println("/////////////////////");
        System.out.println(getAllAccountStatements());

        
        
        



    }
}
