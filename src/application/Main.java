
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        String mainPath = "../models/views/Menu.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(mainPath));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("PEDRA PAPEL TESOURA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
            
    }
}

