package absaliks.jfxdraw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    public void start(Stage primaryStage) {
        // Create a new rectangle
        Rectangle rectangle = new Rectangle(0, 0, 100, 100);
        rectangle.setFill(Color.RED);
        rectangle.setMouseTransparent(true);

        // Create a new pane and add the rectangle to it
        Pane root = new Pane();
        root.setBackground(null);
        root.setMouseTransparent(true);
        root.getChildren().add(rectangle);

        // Create a new scene and add the pane to it
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        // Create a new stage and set the scene
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);

        // Make the stage always on top
        stage.setAlwaysOnTop(true);
        // Show the stage
        stage.show();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.HOME) {
                root.setVisible(true);
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.HOME) {
                root.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}