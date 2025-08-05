import exceptions.InvalidOperationException;

public class ControlledBankAccount extends BasicBankAccount{

    private double minimumBalance;
    private double penaltyAmount;
    
    public ControlledBankAccount(String accountNumber, double annualInterestRate, double minimumBalance,
            double penaltyAmount) throws InvalidOperationException {
        super(accountNumber, annualInterestRate);
        this.minimumBalance = minimumBalance;
        this.penaltyAmount = penaltyAmount;
    }

    @Override
    public void applyMonthlyUpdate() {
        double newBalance = getBalance() - calculateMonthlyFee() + calculateMonthlyInterest();

        if (newBalance < minimumBalance) {
            newBalance -= penaltyAmount;
        }

        setBalance(newBalance);
    }

    
    
}
