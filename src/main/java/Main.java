/*
 * This program allows a user to enter products into a database and keep track of what products are recorded.
 * @author Shanaz Ramsaroop
 * Date: 19/09/2020
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * The main file
 *
 * @author Shanaz Ramsaroop
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 650, 450);
        scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());

        primaryStage.setTitle("Production Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
