package desafio_banco.domain;

/**
 * SavingsAccount
 */
public class SavingsAccount extends Account{

    public SavingsAccount(Client owner) {
        super(owner);
    }

    @Override
    public void printTransactions(){
        System.out.println("=== Savings Account History ===");
        super.printAccountInfo();
        super.printTransactions();
    }
    
}
