
// CSC 205 Class # 14182
// Program 2 
// Author : Nadir Babiker - NAD2153321
// CreditcardAccount class

/*
 **** Creditcard accounts******
1. The balance of a Creditcard account cannot overrun its credit limit
a. The debit method will return false if an attempt to overdraw the account is made.
2. Interest will not be applied to a Creditcard account with a positive balance.
3. The getAccoutInfoAsString method will return a string formatted exactly like this:
 */
public class CreditcardAccount extends BankAccount {

    // data and must be private 
    private int creditLimit = 0; // in pennies

    
    // default constructor 
    public CreditcardAccount() {
        super();
        this.creditLimit = 0;
    }

    // Get the credit limit method that return creditLimit
    public int getCreditLimit() {
        return creditLimit;
    }

    // Set the credit limit method to set to this creditLimit 
    public void setCreditLimit(int creditLimit) {
    	if(creditLimit > 0) {
        this.creditLimit = creditLimit;
    }
   }
  
    @Override 
    // override method of debit   
    public boolean debit(int amount) {
        if (amount <= 0) {
        	return false;
        }
        // Allow balance to go down to -creditLimit
        if (balance - amount < -creditLimit) {
            return false; // exceeds credit limit
        }
        balance -= amount; // charge the card
        return true;
    }

    @Override 
    //  override method  Credit: pay the card
    public boolean credit(int amount) {
        if (amount <= 0) return false;
        balance += amount; // payment reduces debt
        return true;
    }
    
    @Override
    // override applyInterset method 
    public void applyInterest() {            // Apply interest to negative balances
        if (balance < 0) {
            balance += balance * interestRate;  // increase debt
        }
    }

    @Override 
 // string getAccountInfo method to return formatted account info
    public String getAccountInfo() {
        return String.format(
            "Account type  : Creditcard\n" +
            "Account #     : %s\n" +
            "Balance       : $%.2f\n" +
            "Interest rate : %.2f%%\n" +
            "Credit limit  : $%.2f\n",
            accountNumber,
            balance / 100.0,       // convert pennies to dollars
            interestRate * 100,    // convert fraction to percentage
            creditLimit / 100.0    // convert pennies to dollars
        );
    }
}
