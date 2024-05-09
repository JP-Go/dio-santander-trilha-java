package desafio_banco.domain;

/**
 * CheckingAccount
 */
public class CheckingAccount extends Account{

    public CheckingAccount(Client owner) {
        super(owner);
    }

    @Override
    public void printTransactions(){
        System.out.println("=== Checking Account History ===");
        super.printAccountInfo();
        super.printTransactions();
    }
    
}
