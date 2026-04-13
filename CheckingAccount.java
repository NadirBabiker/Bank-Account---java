
//  CheckingAccount class
 /*
  *** Checking accounts***
1. Any CheckingAccount debit that ends with a negative balance will incur an overdraftFee (i.e. the
overdraftFee amount will be subtracted from the balance). A checkingAccount debit will always
succeed.
2. Interest will not be applied to a Checking account with a negative balance.
3. The getAccoutInfoAsString method will return a string formatted exactly like this:
 */

public class CheckingAccount extends BankAccount {
	
	 // data extended from the father class (BankAccount)
	private int overdraftFee= 0;
	
	//  called the defualt constrocter using surper keyword + add new data(overdraftFee)
	public  CheckingAccount() {
		super();
		this.overdraftFee = 0;
		}

	 // new method getOverdraftFee
	 public int getOverdraftFee() {
		return overdraftFee;
	 }
	 
	 // new method setOverdraftFee 
	 public void setOverdraftFee(int overdraftFee) {
		 this.overdraftFee = overdraftFee;
	 }
	 
	//  Debbit  method
	 public boolean debit(int amount) {
	          balance -= amount;
	        // Apply overdraft fee if balance goes below zero
	        if (balance < 0) {
	            balance -= overdraftFee;
	        }
	        return true;
	    }
	 
	 @Override
	 public void applyInterest() {
			if(balance >= 0) {                                      
				  balance += balance * interestRate;    // add the interset amount to the balance                       
				}
			}
			
	// string getAccountInfo  method to return formatted account info
	 public String getAccountInfo() {
			return String.format(
					"Account type  : Checking\n" +
				    "Account #     : %s\n" +
					"Balance       : $%.2f\n" +
					"Interest rate : %.2f%%\n"  +
					"Overdraft fee : $%.2f\n", 
				    accountNumber,
				    balance / 100.0 ,        // pennies convert  dollars 
				    interestRate * 100 ,     // calculate interset as percent 
				    overdraftFee / 100.0);   // pennies convert  dollars 
							
	 }
}
