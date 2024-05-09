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
        return String.format("Transaction of kind=%s, fromAccount=%d/%d owned by %s, "+
                "toAccount=%d/%downed by %s, of value=%f", kind, 
                fromAccount.getAgency(), fromAccount.getAccountNumber(), fromAccount.getOwner().getName(), 
                toAccount.getAgency(), toAccount.getAccountNumber(), toAccount.getOwner().getName(), 
                value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kind == null) ? 0 : kind.hashCode());
        result = prime * result + ((fromAccount == null) ? 0 : fromAccount.hashCode());
        result = prime * result + ((toAccount == null) ? 0 : toAccount.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (kind != other.kind)
            return false;
        if (fromAccount == null) {
            if (other.fromAccount != null)
                return false;
        } else if (!fromAccount.equals(other.fromAccount))
            return false;
        if (toAccount == null) {
            if (other.toAccount != null)
                return false;
        } else if (!toAccount.equals(other.toAccount))
            return false;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        return true;
    }

}
