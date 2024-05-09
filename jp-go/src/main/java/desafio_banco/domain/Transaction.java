package desafio_banco.domain;

import desafio_banco.domain.enums.TransactionKind;

/**
 * Transaction
 */
public class Transaction {

    private TransactionKind kind;
    private Account fromAccount;
    private Account toAccount;
    private double value;

    public Transaction(TransactionKind kind, Account fromAccount, Account toAccount, double value) {
        this.kind = kind;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction of kind=" + kind + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", value="
                + value;
    }

}
