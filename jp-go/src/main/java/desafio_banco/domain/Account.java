package desafio_banco.domain;

import java.util.ArrayList;
import java.util.List;

import desafio_banco.domain.enums.TransactionKind;
import desafio_banco.domain.exceptions.InvalidTransactionException;
import desafio_banco.interfaces.IAccount;

public abstract class Account implements IAccount {
    private static final int AGENCY = 1;
    private static int ACCOUNT_NUMBER = 1;
    private int accountNumber;

    public int getAgency() {
        return AGENCY;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
    private Client owner;

    private List<Transaction> transactions;

    private double balance;

    public Account(Client owner) {
        this.owner = owner;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.accountNumber = Account.ACCOUNT_NUMBER++;
    }

    @Override
    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    @Override
    public void transfer(double value, Account account) {
        this.hasEnoughFundsForTransaction(value, 
                new Transaction(TransactionKind.Transfer, this, account, value));
        this.setBalance(balance - value);
        account.setBalance(account.getBalance() + value);
        this.addTransaction(new Transaction(TransactionKind.Transfer, this, account, value));
        account.addTransaction(new Transaction(TransactionKind.Transfer, this, account, value));
    }

    @Override
    public void withdraw(double value) {
        Transaction transaction = new Transaction(TransactionKind.Withdraw, this, this, value);
        if (value <= 0){ 
            throw new InvalidTransactionException("Value must be greater than 0", transaction);
        }
        this.hasEnoughFundsForTransaction(value, transaction);
        this.setBalance(this.balance - value);
        this.addTransaction(transaction);
    }
    @Override
    public void deposit(double value) {
        Transaction transaction = new Transaction(TransactionKind.Deposit, this, this, value);
        if (value <= 0){ 
            throw new InvalidTransactionException("Value must be greater than 0", transaction);
        }
        this.setBalance(this.balance + value);
        this.addTransaction(transaction);
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
    private void setBalance(double balance) {
        this.balance = balance;
    }
    private void hasEnoughFundsForTransaction(double value,Transaction transaction){
        if (this.balance < value){
            throw new InvalidTransactionException("Insuficient funds", transaction);
        }
    }
    protected void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    protected void printAccountInfo(){
        System.out.println(String.format("Account number: %d \n Agency %d \n Owner: %s\n", this.getAccountNumber(), this.getAgency(), this.getOwner().getName()));
    }


    
}
