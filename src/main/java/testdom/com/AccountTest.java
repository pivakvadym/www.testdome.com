package testdom.com;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Autor: Vadym PIVAK
 * Date: 22/06/2020 11:25
 */

public class AccountTest {
    private double epsilon = 1e-6;  //1 x 10 -6

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    //The deposit and withdraw methods will not accept negative numbers.
    @Test
    public void checkDepositeWithdrawNegative() {
        Account account = new Account(300);
        Assert.assertFalse(account.deposit(-100));
        Assert.assertFalse(account.withdraw(-100));
          }

    //Account cannot overstep its overdraft limit.
    @Test
    public void AccountCannotOverstepItsOverdraftLimit() {
        Account account = new Account(300);
        Assert.assertTrue(account.deposit(100));
        Assert.assertFalse(account.withdraw(500));
    }

    //The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
    @Test
    public void depositAndWithdrawMethodsWillDepositOrWithdrawTheCorrectAmount() {
        Account account = new Account(300);
        account.deposit(200);
        Assert.assertEquals(200, account.getBalance(),0);
        account.withdraw(100);
        Assert.assertEquals(100,account.getBalance(),0);
    }
    //The withdraw and deposit methods return the correct results.
    @Test
    public void depositAndWithdrawMethodsReturnCorrectResult() {
        Account account = new Account(300);
        Assert.assertTrue(account.deposit(200));
        Assert.assertTrue(account.withdraw(100));
    }
}