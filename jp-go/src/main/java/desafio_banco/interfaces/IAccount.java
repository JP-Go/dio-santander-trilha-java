package desafio_banco.interfaces;

import desafio_banco.domain.Account;

public interface IAccount {

    void withdraw(double value);
    void deposit(double value);
    void transfer(double value, Account account);
    void printTransactions();
}
