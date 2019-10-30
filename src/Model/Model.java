package Model;

import java.util.ArrayList;
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
        this.notifyObservers();
        return true;
    }
}
