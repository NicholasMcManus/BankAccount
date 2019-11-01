package Controller;

import Model.Model;
import View.NewAccount;
import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewAccountController implements Observer{
    
    private NewAccount view;
    private Model model;
    
    public NewAccountController(Model m, NewAccount view)
    {
        this.view = view;
        this.model = m;
        model.addObserver(this);
        
        this.addItems();
        this.bindCreate();
    }

    @Override
    public void update(Observable o, Object o1) {
        System.out.println("NewAccount UPDATE!");
        view.resetChoices();
    }
    
    private void addItems()
    {
        ArrayList<String> accountTypes = new ArrayList();
        
        accountTypes.add("Savings account");
        accountTypes.add("Regular checking account");
        accountTypes.add("Interest checking account");
        
        view.setComboList(accountTypes);
    }
    
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
