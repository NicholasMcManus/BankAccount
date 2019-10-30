package View;

//Stuff to get the Windows running

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;

public class AccountList{
    
    //Variables
    private Label selectLabel, depositLabel;
    private ComboBox cBox;
    private TextField initDepositField;
    private Button createAccount;
    
    /**
     * Default constructor for the view
     */
    public AccountList()
    {
        super();
        
        Stage primaryStage = new Stage();
        Scene root;
        
        double widthCol = 3;
        
        //Construct the VBox
        Pane primaryLayout = new Pane();
        //primaryLayout.setStyle("-fx-background-color: #FF0000");
        root = new Scene(primaryLayout, 300, 200);
        
        ReadOnlyDoubleProperty width = root.widthProperty();
        ReadOnlyDoubleProperty height = root.heightProperty();
        
        //Start with the First Label
        selectLabel = new Label("Select Account Type");
        selectLabel.layoutXProperty().bind(width.divide(widthCol));
        
        primaryLayout.getChildren().add(selectLabel);
        
        //Make ComboBox
        cBox = new ComboBox();
        primaryLayout.getChildren().add(cBox);
           
        cBox.layoutXProperty().bind(width.divide(widthCol));
        cBox.layoutYProperty().bind(height.divide(4));
        
        //Make HBox with depositLabel and inputField     
        //InitialLabel Things!
        depositLabel = new Label("Initial Deposit:");
        //depositLabel.layoutXProperty();
        depositLabel.layoutYProperty().bind(height.divide(2));
        
        initDepositField = new TextField();
        initDepositField.layoutXProperty().bind(width.divide(widthCol));
        initDepositField.layoutYProperty().bind(height.divide(2));
        
        primaryLayout.getChildren().add(depositLabel);
        primaryLayout.getChildren().add(initDepositField);
        
        //Add the button to create an account
        createAccount = new Button("Create Account");
        
        createAccount.layoutYProperty().bind(height.divide(4).multiply(3));
        
        primaryLayout.getChildren().add(createAccount);
        createAccount.layoutXProperty().bind(width.divide(widthCol));

        primaryStage.setTitle("Create New Account");
        primaryStage.setScene(root);
        primaryStage.show();
    }
}
