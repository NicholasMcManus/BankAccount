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
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Stage 2");
        
        Button btn = new Button();
        Button btn2 = new Button();
        
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Good-Bye World!");
                System.exit(0);
            }            
        });
        
        btn2.setText("Say 'Good Bye World'");
        
        StackPane root = new StackPane();
        StackPane root2 = new StackPane();
        root.getChildren().add(btn);
        root2.getChildren().add(btn2);
        
        Scene scene = new Scene(root, 300, 250);
        Scene scene2 = new Scene(root2, 300,250);
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        secondaryStage.setScene(scene2);
        secondaryStage.show();
        primaryStage.show();
        
        View.NewAccount test = new View.NewAccount();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
