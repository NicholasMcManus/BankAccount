package bankaccount;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nick McManus
 */
public class BankAccount extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Using print statements to make sure things aren't snagging
        //System.out.println("Initializing View");
        View.View view = new View.View();
        //System.out.println("View Initialized");
        
        //System.out.println("Initializing Model");
        Model.Model model = new Model.Model();
        //System.out.println("Model Initialized");
        
        //Finally bind the view to the model through the controller
        //System.out.println("Calling Control");
        Controller.Controller control = new Controller.Controller(model, view);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
