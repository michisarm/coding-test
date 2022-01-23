import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void negativeNumberWithdraw(){
        Account account = new Account(20);
        Assert.assertEquals(false,account.withdraw(-30));
    }

    @Test
    public void negativeNumberDeposit(){
        Account account = new Account(20);
        Assert.assertEquals(false,account.deposit(-30));
    }

    @Test
    public void overdraftLimit(){
        Account account = new Account(20);
        Assert.assertEquals(false,account.withdraw(30));
    }

    @Test
    public void deposit() {
        Account account = new Account(100);
        account.deposit(20);
        Assert.assertEquals(20, account.getBalance(), epsilon);
    }

    @Test
    public void withdraw() {
        Account account = new Account(100);
        account.deposit(20);
        account.withdraw(20);
        Assert.assertEquals(0, account.getBalance(), epsilon);
    }

    @Test
    public void withdraw_return() {
        Account account = new Account(100);
        Assert.assertEquals(true, account.deposit(20));;
        Assert.assertEquals(true, account.withdraw(20));;
    }

}