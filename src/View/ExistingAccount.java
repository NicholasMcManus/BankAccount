package View;

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
}
