// SavingsAccount class  
/* 
 * *****Savings accounts****
1. A savings account cannot have a negative balance.
a. The debit method will return false if an attempt to overdraw the account is made.
2. The getAccoutInfoAsString method will return a string formatted exactly like this
*/

public class SavingsAccount extends BankAccount {
	      
	 // data extedned from BankAccouont 
	
	
	@Override
	// Interest will not applied to to Savaing acount if = 0 or less 
	public void applyInterest() {
		if(balance > 0) {
		
			 balance += balance *  interestRate;    // Add the interset amount to the balance 
			                              // return new balance 
			}
		}
		
	// getAccountInfo method 
	@Override 
	// string getAccountInfo  method to return formatted account info
	public String getAccountInfo() {
	    return String.format(
	        "Account type  : Savings\n" +
	        "Account #     : %s\n" + 
	        "Balance       : $%.2f\n" +
	        "Interest rate : %.2f%%\n"  ,
	         accountNumber,
	         balance / 100.0,
	         interestRate * 100);
	}
	
	@Override
	public boolean debit(int amount) {
		// TODO Auto-generated method stub
		if(amount <=  0 ) {
			return false;   //chech 
		}
		if(balance <  amount ) {        // insufficient balance 
			return false;
		}else {
			balance = balance - amount;
			return true;
		}
	}

}// end of the savainsAccount class 
