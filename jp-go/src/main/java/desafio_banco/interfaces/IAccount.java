package desafio_banco.interfaces;

public interface IAccount {

    void withdraw(double value);
    void deposit(double value);
    void transfer(double value, IAccount account);
    void printTransactions();
}
