package desafio_banco.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import desafio_banco.domain.enums.TransactionKind;
import desafio_banco.domain.exceptions.InvalidTransactionException;

/**
 * Unit test for SavingsAccount
 */
public class SavingsAccountTests 
{
    private Client dummyClient = new Client();
    private SavingsAccount ut;

    public SavingsAccountTests() {
        this.dummyClient.setName("Jon Doe");
    }

    @Before
    public void init(){
        this.ut = new SavingsAccount(this.dummyClient);
    }


    @Test
    public void shouldBeAbleToDeposit()
    {
        double value = 300;
        ut.deposit(value);

        assertEquals(value, ut.getBalance(),0.0001d);
    }

    @Test
    public void shouldBeAbleToDepositMultipleTimes()
    {
        double finalBalance = 5000;
        ut.deposit(1000);
        ut.deposit(2000);
        ut.deposit(2000);

        assertEquals(finalBalance, ut.getBalance(),0.0001d);
    }

    @Test(expected = InvalidTransactionException.class)
    public void shouldNotBeAbleToDepositANegativeValue()
    {
        ut.deposit(-400);
    }

    @Test
    public void shouldBeAbleToWithdrawLessThanTheBalance()
    {
        ut.deposit(400);
        ut.withdraw(300);
        assertEquals(100, ut.getBalance(),0.0001);
    }

    @Test
    public void shouldBeAbleToWithdrawExactlyTheBalance()
    {
        ut.deposit(400);
        ut.withdraw(400);
        assertEquals(0, ut.getBalance(),0.0001);
    }

    @Test(expected = InvalidTransactionException.class)
    public void shouldNotBeAbleToWithdrawMoreThanTheBalance()
    {
        ut.deposit(400);
        ut.withdraw(500);
    }

    @Test(expected = InvalidTransactionException.class)
    public void shouldNotBeAbleToWithdrawANegativeValue()
    {
        ut.deposit(400);
        ut.withdraw(-200);
        assertEquals(0, ut.getBalance(),0.0001);
    }

    @Test
    public void aSingleTransactionIsSaved()
    {
        ut.deposit(400);
        var expected = new Transaction(TransactionKind.Deposit,ut,ut,400);
        assertThat(ut.getTransactions(),not(ut.getTransactions().isEmpty()));
        assertThat(ut.getTransactions().size(),is(1));
        assertThat(ut.getTransactions(), hasItem(expected));
    }
    @Test
    public void multipleTransactionAreSaved()
    {
        ut.deposit(400);
        ut.withdraw(300);
        var other = new SavingsAccount(this.dummyClient);
        ut.transfer(100,other);
        Transaction[] expected = {new Transaction(TransactionKind.Deposit,ut,ut,400),
                    new Transaction(TransactionKind.Withdraw,ut,ut,300),
                    new Transaction(TransactionKind.Transfer, ut, other, 100)};
        assertThat(ut.getBalance(), is(0d));
        assertThat(ut.getTransactions(),not(ut.getTransactions().isEmpty()));
        assertThat(ut.getTransactions().size(),is(3));
        assertThat(ut.getTransactions(), hasItems(expected));
    }

    @Test
    public void canTransferWithSufficientFunds()
    {
        ut.deposit(100);
        var other = new SavingsAccount(this.dummyClient);
        ut.transfer(99,other);
        Transaction[] expected = {new Transaction(TransactionKind.Deposit,ut,ut,100),
            new Transaction(TransactionKind.Transfer,ut,other,99)} ;

        Transaction[] expectedOther = { new Transaction(TransactionKind.Transfer,ut,other,99)} ;
        assertThat(ut.getBalance(), is(1d));
        assertThat(ut.getTransactions(),not(ut.getTransactions().isEmpty()));
        assertThat(ut.getTransactions().size(),is(2));
        assertThat(ut.getTransactions(), hasItems(expected));

        assertThat(other.getBalance(), is(99d));
        assertThat(other.getTransactions(),not(other.getTransactions().isEmpty()));
        assertThat(other.getTransactions().size(),is(1));
        assertThat(other.getTransactions(), hasItems(expectedOther));
    }

    @Test(expected = InvalidTransactionException.class)
    public void cannotTransferWithInsufficientFunds()
    {
        ut.deposit(100);
        var other = new SavingsAccount(this.dummyClient);
        ut.transfer(101,other);
    }

}
