import java.util.List;

public interface Account {
    double deposit(double amount);
    double withdraw(double amount);
    List<Double> getAllDeposits();
    List<Double> getAllWithdraws();
    List<Double> getDepositsLessThan(double amount);
    List<Double> getWithdrawsGreaterThan(double amount);
}
/*
    1. Create a class named BankAccount that implements the provided interface
    2. It should contain the following properties:
        - balance: Double
        - transactions: List<Double>
    3. The deposit method should:
        - Only allow amounts greater than 0
        - Add the amount passed in to the balance
        - Add the amount passed in to the transactions List as a positive number
        - Return the new balance
    4. The withdraw method should:
        - Only allow amount greater than 0
        - Should only withdraw if sufficient funds available
        - Subtract the amount passed in from the balance
        - Add the amount passed in to the transactions List as a negative number
        - Return the new balance
    5. The getAllDeposits method should:
        - Return only the deposits (positive numbers) from the transactions property
    6. The getAllWithdraws method should:
        - Return only the withdraws (negative numbers) from the transactions property
    7. The getDepositsLessThan method should:
        - Return only the deposits (positive numbers) that are less than the amount passed in
    8. The getWithdrawsGreaterThan method should:
        - Return only the withdraws (negative numbers) that are greater than the amount passed in
 */