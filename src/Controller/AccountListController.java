package Controller;
import Model.Model;
import View.AccountList;

import java.util.Observable;
import java.util.Observer;

public class AccountListController implements Observer{
    
    private AccountList view;
    
    public AccountListController(Model m, AccountList view)
    {
        this.view = view;
        m.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        System.out.println("AccountList UPDATE");
        if(o instanceof Model)
            updateAccountList((Model)o);
        else
            System.out.println("Object was not type: Model");
    }
    
    public void updateAccountList(Model source)
    {
        String output = "";
        
        for(int i = 0; i < source.getAccountList().size(); i++)
        {
            output += (source.getAccountList().get(i) + "\n");
        }
        System.out.println("Update the account list to!\n" + output);
        view.updateDisplay(output);
    }
}
