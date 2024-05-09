package desafio_banco.domain;

import java.util.List;

import desafio_banco.interfaces.IAccount;

public abstract class Account implements IAccount {
    private static final int AGENCY = 1;
    private static int ACCOUNT_NUMBER = 1;

    public static int getAgency() {
        return AGENCY;
    }
    public static int getAccountNumber() {
        return ACCOUNT_NUMBER;
    }
    private Client owner;

    private List<Transaction> transactions;

    private double balance;

    public Account(Client owner) {
        this.owner = owner;
        this.balance = 0;
        this.transactions = List.of();
    }

    @Override
    public void printTransactions() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void transfer(double value, IAccount account) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void withdraw(double value) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void deposit(double value) {
        // TODO Auto-generated method stub
        
    }
    public Client getOwner() {
        return owner;
    }
    public void setOwner(Client owner) {
        this.owner = owner;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public double getBalance() {
        return balance;
    }
    private void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    private void setBalance(double balance) {
        this.balance = balance;
    }

    
}
