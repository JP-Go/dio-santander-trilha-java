package desafio_banco.domain.enums;

/**
 * TransactionKind
 */
public enum TransactionKind {
    Withdraw("WITHDRAW"),Deposit("DEPOSIT"),Transfer("TRANSFER");

    private TransactionKind(String kind){ }
    
}
