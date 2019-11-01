package Model;

public class BankAccount {
    
    //Variables
    private static int accountNum = 0;
    private int accountID;
    private String accountName;
    private double accountBalance;
    
    /**
     * The default constructor for a bank account
     */
    BankAccount()
    {
        this("Normal Checking Account", 0);
    }
    
    /**
     * The constructor giving the account a custom name
     * @param name The name for the account
     * @param initialBalance The initial balance of the account
     */
    BankAccount(String name, double initialBalance)
    {
        this.accountName = name;
        this.accountBalance = initialBalance;
        this.accountID = ++accountNum;
        System.out.println(this);
    }
    
    /**
     * Getting the value of the ID field
     * @return The integer value of ID
     */
    public int getID()
    {
        return this.accountID;
    }
    
    /**
     * Get the account name
     * @return The account name
     */
    public String getAccountName()
    {
        return this.accountName;
    }
    
    /**
     * Get the current account balance
     * @return The current account balance
     */
    public double getBalance()
    {
        return this.accountBalance;
    }
    
    /**
     * Attempt to perform a withdraw of funds from the account
     * @param amount Amount to remove from the account, will fail if negative
     *  or will overdraw account
     */
    public void withdraw(double amount)
    {
        if(amount > this.accountBalance)
        {
            System.out.println("Invalid Transaction: Account would be overdrawn");
            return;
        }
        else if(amount < 0)
        {
            System.out.println("Invalid Transaction: Amount cannot be less than 0");
            return;
        }
        
        this.accountBalance -= amount;
    }
    
    /**
     * Attempt to deposit money into a bank account
     * @param amount The amount to insert into the account, will fail if negative
     */
    public void deposit(double amount)
    {
        if(amount < 0)
        {
            System.out.println("Invalid Transaction: Amount cannot be less than 0");
            return;
        }
        
        this.accountBalance += amount;
    }

    @Override
    public String toString() {
        return (accountName + " " + accountID + ": balance = $" + String.format("%.2f",accountBalance));
    }
}
