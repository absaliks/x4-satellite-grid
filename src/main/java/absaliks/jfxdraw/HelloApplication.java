package absaliks.jfxdraw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    private Parent graphics() {
        Group root = new Group();
        root.setMouseTransparent(true);

        // Create the large center circle
        double centerX = 200; // X coordinate of the center point
        double centerY = 200; // Y coordinate of the center point
        double radius = 100; // Radius of the smaller circles
        Circle centerCircle = new Circle(centerX, centerY, radius);
        centerCircle.setStroke(Color.RED);
        centerCircle.setFill(Color.TRANSPARENT);

        // Create the smaller circles around the center circle
        int numCircles = 5;
        double angle = 0;
        double angleStep = 2 * Math.PI / numCircles;
        double distanceFromCenter = radius + 60;

        for (int i = 0; i < numCircles; i++) {
            double x = centerX + distanceFromCenter * Math.cos(angle);
            double y = centerY + distanceFromCenter * Math.sin(angle);
            Circle circle = new Circle(x, y, radius);
            System.out.printf("x=%.1f, y=%.1f, r=%.1f%n", x, y, radius);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLUE);
            root.getChildren().add(circle);
            angle += angleStep;
        }
        return root;
    }

    public void start(Stage primaryStage) {
        // Create a new scene and add the pane to it
        Scene scene = new Scene(graphics(), 800, 800);
        scene.setFill(Color.TRANSPARENT);

        // Create a new stage and set the scene
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);

        // Make the stage always on top
        stage.setAlwaysOnTop(true);
        // Show the stage
        stage.show();

        /* Visibility
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.HOME) {
                stage.show();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.HOME) {
                stage.hide();
            }
        });*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}