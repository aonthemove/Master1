import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    BankAccount acc;

    @Before
    public void setUp() {
        acc = new BankAccount(50.0);
    }

    @Test
    public void testDeposit() {
        assertEquals(60.0, acc.deposit(10.0), 0.0);
        assertEquals(60.0, acc.deposit(-20.0), 0.0);
        assertEquals(75.0, acc.deposit(15.0), 0.0);
    }

    @Test
    public void testWithdraw() {
        assertEquals(40.0, acc.withdraw(10.0), 0.0);
        assertEquals(40.0, acc.withdraw(-20.0), 0.0);
        assertEquals(40.0, acc.withdraw(200.0), 0.0);
        assertEquals(25.0, acc.withdraw(15.0), 0.0);
    }

    @Test
    public void testGetAllDeposits() {
        acc.deposit(10.0);
        acc.deposit(20.0);
        acc.deposit(5.0);
        acc.deposit(15.0);
        acc.withdraw(30.0);
        acc.withdraw(5.0);

        List<Double> expected = new ArrayList<>();
        expected.add(10.0);
        expected.add(20.0);
        expected.add(5.0);
        expected.add(15.0);

        assertEquals(expected, acc.getAllDeposits());
    }

    @Test
    public void testGetAllWithdraws() {
        acc.deposit(10.0);
        acc.deposit(20.0);
        acc.deposit(5.0);
        acc.deposit(15.0);
        acc.withdraw(30.0);
        acc.withdraw(5.0);

        List<Double> expected = new ArrayList<>();
        expected.add(-30.0);
        expected.add(-5.0);

        assertEquals(expected, acc.getAllWithdraws());
    }

    @Test
    public void testGetDepositsLessThan() {
        acc.deposit(10.0);
        acc.deposit(20.0);
        acc.deposit(5.0);
        acc.deposit(15.0);
        acc.deposit(2.5);

        List<Double> expected1 = new ArrayList<>();
        expected1.add(10.0);
        expected1.add(5.0);
        expected1.add(15.0);
        expected1.add(2.5);

        List<Double> expected2 = new ArrayList<>();
        expected2.add(5.0);
        expected2.add(2.5);

        assertEquals(expected1, acc.getDepositsLessThan(20.0));
        assertEquals(expected2, acc.getDepositsLessThan(10.0));
    }

    @Test
    public void testGetWithdrawsGreaterThan() {
        acc.withdraw(1.0);
        acc.withdraw(5.0);
        acc.withdraw(15.0);
        acc.withdraw(20.0);
        acc.withdraw(2.5);

        List<Double> expected1 = new ArrayList<>();
        expected1.add(-5.0);
        expected1.add(-15.0);
        expected1.add(-20.0);

        List<Double> expected2 = new ArrayList<>();
        expected2.add(-15.0);
        expected2.add(-20.0);

        assertEquals(expected1, acc.getWithdrawsGreaterThan(3.0));
        assertEquals(expected2, acc.getWithdrawsGreaterThan(12.0));
    }
}
