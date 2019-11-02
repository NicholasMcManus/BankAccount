package View;

//Stuff to get the Windows running
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.TextArea;

import javafx.scene.layout.BorderPane;

public class AccountList{
    //Variables
    private TextArea display;
    
    /**
     * Default Constructor for an AccountListGUI class
     */
    public AccountList()
    {
        Stage primaryStage = new Stage();
        Scene root;
        BorderPane layout = new BorderPane();
        
        display = new TextArea();
        display.setText("Please Create an Account!");
        display.setEditable(false);
        
        layout.setCenter(display);
        
        root = new Scene(layout, 300, 250);
        primaryStage.setTitle("Account List");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    /**
     * Update the display to show the string that was passed in
     * @param newString The string to have the display updated to
     */
    public void updateDisplay(String newString)
    {
        display.setText(newString);
    }
}