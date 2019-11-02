package bankaccount;

import javafx.application.Application;
import javafx.stage.Stage;

public class BankAccount extends Application {
    
    /**
     * The start method that get the ball rolling
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        //Really this method just puts together a view, model and calls
        //the controller to stitch them together
        
        View.View view = new View.View();
        Model.Model model = new Model.Model();
        Controller.Controller control = new Controller.Controller(model, view);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
