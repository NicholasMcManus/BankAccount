package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExistingAccount{

    //Declare Variables
    private Button accountSelect, withdraw, deposit, delete;
    private TextField account, inputWithdraw, inputDeposit, balance;
    private Label lBalance;
    
    /**
     * Default constructor for the GUI that modifies Existing Bank Accounts
     */
    public ExistingAccount()
    {
        //Local Variables
        Stage primaryStage = new Stage();
        Scene root;
        GridPane layout = new GridPane();
        
        //Start putting together the GridPane
        //Account
        accountSelect = new Button("Select Account");
        account = new TextField();
        
        layout.add(account, 0, 0);
        layout.add(accountSelect, 1, 0);
        
        //Deposit
        deposit = new Button("Deposit");
        inputDeposit = new TextField();
        
        layout.add(inputDeposit, 0, 1);
        layout.add(deposit, 1, 1);
        
        //Withdraw
        withdraw = new Button("Withdraw");    
        inputWithdraw = new TextField();
        
        layout.add(inputWithdraw, 0, 2);
        layout.add(withdraw, 1, 2);
        
        //Balance
        balance = new TextField();
        balance.setDisable(true);
        balance.setStyle("-fx-opacity: 1;");
        
        lBalance = new Label("Balance");
                
        //Delete
        delete = new Button("Delete");
        
        layout.add(lBalance, 0, 3);
        
        //Alligning the Label next to its field
        GridPane.setHalignment(lBalance, HPos.RIGHT);
        GridPane.setValignment(lBalance, VPos.CENTER);
        
        layout.add(balance, 1, 3);
        layout.add(delete, 1, 4);
        
        //Try making the layout more dynamic
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(5);
        layout.setVgap(10);
        
        root = new Scene(layout, 325, 200);
        primaryStage.setTitle("Access an Existing Account");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    /**
     * Bind an action to the account select button
     * @param action The action to bind
     */
    public void bindSelectButton(EventHandler<ActionEvent> action)
    {
        this.accountSelect.setOnAction(action);
    }
    
    /**
     * Bind an action to the withdraw button
     * @param action The action to bind
     */
    public void bindWithdrawButton(EventHandler<ActionEvent> action)
    {
        this.withdraw.setOnAction(action);
    }
    
    /**
     * Bind an action to the deposit button
     * @param action The action to bind
     */
    public void bindDepositButton(EventHandler<ActionEvent> action)
    {
        this.deposit.setOnAction(action);
    }
    
    /**
     * Bind an action to the delete button
     * @param action The action to bind
     */
    public void bindDeleteButton(EventHandler<ActionEvent> action)
    {
        this.delete.setOnAction(action);
    }
    
    /**
     * Retrieve the amount to withdraw as a double
     * @return The amount to withdraw if invalid - 0 otherwise
     */
    public double getWithdraw()
    {
        try
        {
        return Double.parseDouble(inputWithdraw.getText());
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
                
    }
    
    /**
     * Retrieve the amount to deposit as a double
     * @return The amount to deposit if valid - 0 otherwise
     */
    public double getDeposit()
    {
        try
        {
            return Double.parseDouble(inputDeposit.getText());
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
    
    /**
     * Retrieve the current accountID entered by the user
     * @return The account selected by the user, -1 returned on error
     */
    public int getAccountID()
    {
        //Local Varaibles
        int input;
        try
        {
            input = Integer.parseInt(account.getText());
        }
        catch(NumberFormatException e)
        {
            input = -1;
        }
        return input;
    }
    
    /**
     * Set the balance of the GUI
     * @param balance The balance to put on the GUI
     */
    public void setBalance(double balance)
    {
        this.balance.setText(String.format("%.2f",balance));
    }
    
    /**
     * Set the balance of the GUI to something that is not a double
     * @param input The special output to put in the balance field
     */
    public void setBalanceField(String input)       
    {
        this.balance.setText(input);
    }
    
    /**
     * Call this to reset the input fields, useful after performing a deposit
     * withdraw or account change
     */
    public void resetInputFields()
    {
        this.inputDeposit.setText("");
        this.inputWithdraw.setText((""));
    }
    
}
