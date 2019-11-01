package Controller;

import Model.Model;
import View.ExistingAccount;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExistingAccountController implements Observer{

    private int currentAccount = -1;
    private Model m;
    private ExistingAccount view;
    
    public ExistingAccountController(Model m, ExistingAccount view)
    {
        this.m = m;
        this.view = view;
        
        m.addObserver(this);
        
        setSelectButton();
        setDepositButton();
        setWithdrawButton();
        setDeleteButton();
    }
    
    @Override
    public void update(Observable o, Object o1) {
        /*
        On update, this function should update the balance field
        if an account is selected
        */
        checkAccountInput();
        view.resetInputFields();
    }
    
    private void checkAccountInput()
    {
        currentAccount = view.getAccountID();
        if(m.getAccount(currentAccount) != null)
        {
            view.setBalance(m.getAccount(currentAccount).getBalance());
        }
        else
        {
            currentAccount = -1;
            invalidAccount();
        }
    }
    
    private void setSelectButton()
    {
        view.bindSelectButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAccountInput();
            }
        });
    }

    private void setWithdrawButton()
    {
        view.bindWithdrawButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //-1 represents an invalid account
                if(currentAccount != -1)
                {
                    m.withdraw(currentAccount, view.getWithdraw());
                }
                else
                {
                    invalidAccount();
                }
            }
        });
    }
    
    private void invalidAccount()
    {
        view.setBalanceField("Invalid");
    }
    
    private void setDepositButton()
    {
        view.bindDepositButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //-1 represents an invalid account
                if(currentAccount != -1)
                {
                    m.deposit(currentAccount, view.getDeposit());
                }
                else
                {
                    invalidAccount();
                }
            }
        });
    }
    
    private void setDeleteButton()
    {
        view.bindDeleteButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                boolean success = false;
                
                if(currentAccount != -1)
                    success = m.removeAccount(currentAccount);
                
                if(success)
                    view.setBalanceField("Success");
                else
                    view.setBalanceField("Failure");
            }
        });
    }
}
