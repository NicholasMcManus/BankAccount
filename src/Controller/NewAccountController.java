package Controller;

import Model.Model;
import View.NewAccount;
import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewAccountController implements Observer{
    //Class Variables
    private NewAccount view;
    private Model model;
    
    /**
     * Construct a new Object that controls a NewAccountGUI
     * @param m The model containing the accounts
     * @param view The NewAccountGUI that needs to be modified
     */
    public NewAccountController(Model m, NewAccount view)
    {
        this.view = view;
        this.model = m;
        model.addObserver(this);
        
        this.addItems();
        this.bindCreate();
    }

    /**
     * When notified by an observable class it will update its internal list
     * @param o The observable object calling notifyObservers
     * @param o1 Some object
     */
    @Override
    public void update(Observable o, Object o1) {
        view.resetChoices();
    }
    
    /**
     * Add accounts to the ComboBox using an ArrayList
     */
    private void addItems()
    {
        ArrayList<String> accountTypes = new ArrayList();
        
        accountTypes.add("Savings account");
        accountTypes.add("Regular checking account");
        accountTypes.add("Interest checking account");
        
        view.setComboList(accountTypes);
    }
    
    /**
     * Make the create account button function
     */
    private void bindCreate()
    {
        view.resetChoices();
        
        view.bindCreateButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.addAccount(view.getAccountType(), view.getBalance());
            }
        });
    }
    
}
