import exceptions.InvalidOperationException;

public class BasicBankAccount {

    private String accountNumber;
    private double balance;
    private double annualInterestRate;
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public BasicBankAccount(String accountNumber, double annualInterestRate) throws InvalidOperationException {
        this.accountNumber = accountNumber;
        this.annualInterestRate = annualInterestRate;
        balance = 0;
    }
    
    public void deposit(double value) throws InvalidOperationException{
        if (value<0) throw new InvalidOperationException("Deposit amount must be greater than 0");
        else balance+=value;
    }

    public void withdraw(double value) throws InvalidOperationException{
        if (value<0) throw new InvalidOperationException("Withdraw amount must be greater than 0");
        else if (balance<value) 
            throw new InvalidOperationException("Withdrawal amount must be less than the current balance");
        else balance-=value;
    }

    public double calculateMonthlyFee(){
        if (balance*0.1<10) return balance*0.1;
        else return 10;
    }

    public double calculateMonthlyInterest(){
        if (balance == 0) return 0;
        double monthlyRate = (annualInterestRate / 100.0) / 12.0;
        return balance * monthlyRate;
    }

    public void applyMonthlyUpdate(){
        balance = balance + calculateMonthlyInterest() - calculateMonthlyFee();
    }
    
    
}
