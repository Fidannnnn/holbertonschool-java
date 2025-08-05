import exceptions.InvalidOperationException;

public class FeeBasedBankAccount extends BasicBankAccount {

    private int transactionCount;

    public FeeBasedBankAccount(String accountNumber, double annualInterestRate)
            throws InvalidOperationException {
        super(accountNumber, annualInterestRate);
        transactionCount = 0;
    }

     public int getTransactionCount() {
        return transactionCount;
    }

    @Override
    public void deposit(double value) throws exceptions.InvalidOperationException {
        super.deposit(value);         
        transactionCount++;
        setBalance(getBalance() - 0.10);  
    }

    @Override
    public void withdraw(double value) throws exceptions.InvalidOperationException {
        super.withdraw(value);           
        transactionCount++;
        setBalance(getBalance() - 0.10); 
    }
    
}
