package Controller;

import Model.Model;
import View.ExistingAccount;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExistingAccountController implements Observer{

    //Local Variables
    private int currentAccount = -1;
    private Model m;
    private ExistingAccount view;
    
    /**
     * Construct a new class for the ExistingAccountGUI
     * @param m The model containing accounts
     * @param view The ExistingAccountGUI to be bound
     */
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
    
    /**
     * When notified by an observable class it will update its internal list
     * @param o The observable object calling notifyObservers
     * @param o1 Some object
     */
    @Override
    public void update(Observable o, Object o1) {
        /*
        On update, this function should update the balance field
        if an account is selected
        */
        checkAccountInput();
        view.resetInputFields();
    }
    
    /**
     * Check to make sure the account selected is the one loaded
     * Basically: Make sure the correct account is loaded for a transaction
     */
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
    
    /**
     * Bind the select button to a passed EventHandler
     */
    private void setSelectButton()
    {
        view.bindSelectButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAccountInput();
            }
        });
    }

    /**
     * Bind the withdraw button so it actually works
     */
    private void setWithdrawButton()
    {
        view.bindWithdrawButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(view.getAccountID() != currentAccount)
                    checkAccountInput();
                
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
    
    /**
     * Set the account state to invalid
     */
    private void invalidAccount()
    {
        view.setBalanceField("Invalid");
    }
    
    /**
     * Make the depositButton do work and things
     */
    private void setDepositButton()
    {
        view.bindDepositButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(view.getAccountID() != currentAccount)
                    checkAccountInput();
                
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
    
    /**
     * Make the delete button destroy accounts
     */
    private void setDeleteButton()
    {
        view.bindDeleteButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                //Make sure the right account is signed in
                if(view.getAccountID() != currentAccount)
                    checkAccountInput();
                
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
