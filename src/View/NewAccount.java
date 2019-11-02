package View;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewAccount{

    //Variables
    private Label selectLabel, depositLabel;
    private ComboBox cBox;
    private TextField initDepositField;
    private Button createAccount;

    /**
     * Default constructor for the view
     */
    public NewAccount()
    {
        super();
        
        Stage primaryStage = new Stage();
        Scene root;
                
        //Construct the VBox
        GridPane primaryLayout = new GridPane();
        primaryLayout.setHgap(5);
        primaryLayout.setVgap(10);
        primaryLayout.setAlignment(Pos.CENTER);
        
        root = new Scene(primaryLayout, 300, 200);

        //Start with the First Label
        selectLabel = new Label("Select Account Type");
        primaryLayout.add(selectLabel,0,0);
        
        //Make ComboBox
        cBox = new ComboBox();
        primaryLayout.add(cBox, 0,1);
        centerNode(cBox);   
        
        //InitialLabel Things!
        depositLabel = new Label("Initial Deposit:");
        
        initDepositField = new TextField();
        
        GridPane.setHalignment(initDepositField, HPos.RIGHT);
        GridPane.setValignment(initDepositField, VPos.CENTER);
        
        primaryLayout.add(depositLabel, 0, 2);
        primaryLayout.add(initDepositField, 1, 2);
        
        //Add the button to create an account
        createAccount = new Button("Create Account");
        //createAccount.setPrefWidth(Double.MAX_VALUE);
        
        primaryLayout.add(createAccount, 0, 3);
        this.centerNode(createAccount);
        
        
        primaryStage.setTitle("Create New Account");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    /**
     * The node passed will be centered on the GridPane
     * @param current The node to be centered
     */
    private void centerNode(Node current)
    {
        GridPane.setHalignment(current, HPos.CENTER);
        GridPane.setValignment(current, VPos.CENTER);
        GridPane.setColumnSpan(current, GridPane.REMAINING);
    }
    
    /**
     * Bind some action to the button that creates an account
     * @param action The action to be performed
     */
    public void bindCreateButton(EventHandler<ActionEvent> action)
    {
        createAccount.setOnAction(action);
    }
    
    /**
     * Get the account type from the ComboBox
     * @return The selection from the ComboBox
     */
    public String getAccountType()
    {
        return (String)cBox.getValue();
    }
    
    /**
     * Set the ComboBox to an ArrayList of Strings
     * @param list The list of strings
     */
    public void setComboList(ArrayList<String> list)
    {
        cBox.getItems().addAll(list);
    }
    
    /**
     * Get the balance entered by the user
     * @return The absolute value of the users input to handle negatives, 
     * or 0 if invalid characters are used
     */
    public double getBalance()
    {
        try
        {
            return Math.abs(Double.parseDouble(this.initDepositField.getText()));
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
    
    /**
     * Reset all user accessible fields 
     */
    public void resetChoices()
    {
        initDepositField.setText("0");
        cBox.setValue(cBox.getItems().get(0));
    }
    
}
