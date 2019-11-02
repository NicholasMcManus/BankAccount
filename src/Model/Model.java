package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{

    //Class Variables
    ArrayList<BankAccount> accounts;
    
    /**
     * Default Constructor
     */
    public Model()
    {
        accounts = new ArrayList();
    }
    
    /**
     * Add a new BankAccount to the program
     * @param name The name for the account
     * @param initialBalance The starting balance for the account
     */
    public void addAccount(String name, double initialBalance)
    {
        accounts.add(new BankAccount(name, initialBalance));
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Return the account based on the ID selected
     * @param accountID The ID of the account
     * @return The account, if one exists
     */
    public BankAccount getAccount(int accountID)
    {
        //Check the list for the account in question      
        for(int i = 0; i < accounts.size(); i++)
        {
            BankAccount current = accounts.get(i);
            if(current.getID() == accountID)
            {
                return current;
            }
        }
        
        return null;
    }
    
    /**
     * Perform the withdraw transaction with an account
     * @param accountID The ID of the targeted account
     * @param amount The amount to attempt to withdraw
     * @return 
     */
    public boolean withdraw(int accountID, double amount)
    {
        //Declare object making sure is it not null
        BankAccount target = getAccount(accountID);
        
        if(target == null)
            return false;
        //Declare the rest of the variables
        double oldBalance = target.getBalance();
        
        //Calculation
        target.withdraw(amount);
        
        //Return if the transaction was successful
        if(oldBalance != target.getBalance())
        {
            //Notify the observers
            this.setChanged();
            this.notifyObservers();
            
            return true;
        }
        return false;
    }
    
    /**
     * Attempt to deposit a provided amount into an account
     * @param accountID The account to deposit into
     * @param amount The amount to try and deposit into the account
     * @return 
     */
    public boolean deposit(int accountID, double amount)
    {
        //Declare object making sure is it not null
        BankAccount target = getAccount(accountID);
        
        if(target == null)
            return false;
        //Declare the rest of the variables
        double oldBalance = target.getBalance();
        
        //Calculation
        target.deposit(amount);
        
        //Return if the transaction was successful
        if(oldBalance != target.getBalance())
        {
            //Notify the observers
            this.setChanged();
            this.notifyObservers();
            
            return true;
        }
        return false;
        
    }
    
    /**
     * Try to remove the account specified by the ID
     * @param accountID The ID of the account to remove
     * @return 
     */
    public boolean removeAccount(int accountID)
    {
        //Retrieve the bank account
        BankAccount target = this.getAccount(accountID);
        
        //Null check
        if(target == null)
            return false;
        
        accounts.remove(target);
        this.setChanged();
        this.notifyObservers();
        return true;
    }
    
    /**
     * Allow usage of an unmodifiable list of accounts
     * @return An unmodifiable List of values
     */
    public List getAccountList()
    {
        return java.util.Collections.unmodifiableList(accounts);
    }
}
