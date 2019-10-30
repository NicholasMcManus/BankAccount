package View;

//Stuff to get the Windows running
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.TextArea;

import javafx.scene.layout.BorderPane;

public class AccountList{
    //Variables
    private TextArea display;
    
    public AccountList()
    {
        Stage primaryStage = new Stage();
        Scene root;
        BorderPane layout = new BorderPane();
        
        display = new TextArea();
        display.setText("This is a test\nA TEST I SAY");
        display.setEditable(false);
        
        layout.setCenter(display);
        
        root = new Scene(layout, 300, 250);
        primaryStage.setTitle("Account List");
        primaryStage.setScene(root);
        primaryStage.show();
    }
}