package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/sample.fxml"));
        primaryStage.setTitle("PDB Project");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public void stop(){
        System.out.println("closing...");
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}