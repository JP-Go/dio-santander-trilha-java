package desafio_banco.domain.exceptions;

import desafio_banco.domain.Transaction;

public class InvalidTransactionException extends IllegalArgumentException {

    public InvalidTransactionException(String reason,Transaction transaction){
        super(String.format("%s cannot occur: %s", transaction,reason));
    }
    
}
