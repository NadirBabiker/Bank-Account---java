
// CSC 205 Class # 14182
//Program 2 
// Author : Nadir Babiker - NAD2153321
// Program 2  BankAccount class
/* All Bank Accounts
1. All accounts have balance, credit and debit amounts, and fees stored and passed as a number of
pennies (int).
2. All debit amounts will be subtracted from the balance, and all credit amounts will be added to
the balance.
3. All bank accounts have a non-negative interest rate (0.02 would be a 2% interest rate).
4. When applying interest, interest amount is calculated by multiplying the balance by the interest
rate.
5. When applying interest, interest amount is added to the balance.
6. Interest will not be applied to any Savings or Checking account with a balance of zero or less.
7. Debit methods will return false if the transaction cannot be made because of insufficient
balance or insufficient credit limit. Otherwise they will return true. A Credit will always return
true
# protected , - Private ,  + public , ~ package 
 */ 
public  abstract  class BankAccount {
	
	// data
	protected String accountNumber =  "0000-0000-0000-0000";
	protected double interestRate = 0;
	protected int balance = 0;   
	
	//  methods 
	public boolean credit(int amount){
			balance = balance + amount;
			return true;
	}
	
	// Abstract debit method no body code
	public abstract boolean debit(int amount);
	
	// Get method 
	public int getBalance () {
		return balance;
	}
	
	// Set Method 
	public String getAccountNumber() {
		return accountNumber ; 
	}
	 
	// Set AccountNumber void  method 
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	// getIntersetRate  to return interest 
	public double getInterestRate() { 
		return this.interestRate ;   //  all Bank accounts hae interset rate (0.02 )
	}
	
	// setInterestRate method
	public void setInterestRate(double interestRate) {
		if(interestRate >= 0) {
			this.interestRate = interestRate;
		}
	}
	
	// Abstract methods 
	public abstract void applyInterest();
	
	 // 
	public  abstract String getAccountInfo();
	
}// end of the class
