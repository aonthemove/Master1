import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Account {
    private double balance;
    private List<Double> transactions;

    public BankAccount(double balance) {
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public double deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
            this.transactions.add(amount);
        }

        return this.balance;
    }

    public double withdraw(double amount) {
        if (amount > 0.0 && this.balance >= amount) {
            this.balance -= amount;
            this.transactions.add(amount * -1);
        }

        return this.balance;
    }

    public List<Double> getAllDeposits() {
        List<Double> deposits = new ArrayList<>();

        for (Double t : this.transactions) {
            if (t > 0.0) {
                deposits.add(t);
            }
        }

        return deposits;
    }

    public List<Double> getAllWithdraws() {
        List<Double> withdraws = new ArrayList<>();

        for (Double t : this.transactions) {
            if (t < 0.0) {
                withdraws.add(t);
            }
        }

        return withdraws;
    }

    public List<Double> getDepositsLessThan(double amount) {
        List<Double> deposits = new ArrayList<>();

        for (Double t : this.transactions) {
            if (t > 0.0 && t < amount) {
                deposits.add(t);
            }
        }

        return deposits;
    }

    public List<Double> getWithdrawsGreaterThan(double amount) {
        List<Double> withdraws = new ArrayList<>();

        for (Double t : this.transactions) {
            if (t < 0.0 && t * -1 > amount) {
                withdraws.add(t);
            }
        }

        return withdraws;
    }
}
