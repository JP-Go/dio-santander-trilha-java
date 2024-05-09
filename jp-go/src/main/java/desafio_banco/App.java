package desafio_banco;

import desafio_banco.domain.Account;
import desafio_banco.domain.CheckingAccount;
import desafio_banco.domain.Client;
import desafio_banco.domain.SavingsAccount;

public class App 
{

	public static void main(String[] args) {
		Client venilton = new Client();
		venilton.setName("Venilton");
		
		Account cc = new CheckingAccount(venilton);
		Account poupanca = new SavingsAccount(venilton);

		cc.deposit(100);
		cc.transfer(100, poupanca);
		
		cc.printTransactions();
		poupanca.printTransactions();
	}

}
