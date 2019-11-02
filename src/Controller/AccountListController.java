package Controller;
import Model.Model;
import View.AccountList;

import java.util.Observable;
import java.util.Observer;

public class AccountListController implements Observer{
    
    //Class Variables
    private AccountList view;
    
    /**
     * Constructor for the class
     * @param m An observable model
     * @param view The view that needs to be bound
     */
    public AccountListController(Model m, AccountList view)
    {
        this.view = view;
        m.addObserver(this);
    }

    /**
     * When notified by an observable class it will update its internal list
     * @param o The observable object calling notifyObservers
     * @param o1 Some object
     */
    @Override
    public void update(Observable o, Object o1) {
        if(o instanceof Model)
            updateAccountList((Model)o);
        else
            System.out.println("Object was not type: Model");
    }
    
    /**
     * Update the account list from a provided model
     * @param source 
     */
    public void updateAccountList(Model source)
    {
        String output = "";
        
        for(int i = 0; i < source.getAccountList().size(); i++)
        {
            output += (source.getAccountList().get(i) + "\n");
        }
        view.updateDisplay(output);
    }
}
