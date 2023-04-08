package absaliks.jfxdraw;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static absaliks.jfxdraw.Utils.circle;
import static absaliks.jfxdraw.Utils.line;

public class HelloApplication extends Application {

  private Parent graphics() {
    Group root = new Group();
    root.setMouseTransparent(true);
    var children = root.getChildren();

    // Create the large center circle
    Point2D screenCenter = Utils.getScreenCenter();

    double radius = 325; // Radius of the smaller circles
    children.add(circle(screenCenter, radius, Color.RED));

    // Create the smaller circles around the center circle
    int numCircles = 6;
    double angle = 0;
    double angleStep = 2 * Math.PI / numCircles;
    double distanceFromCenter = radius / 0.585;

    for (int i = 0; i < numCircles; i++) {
      Point2D satelliteCenter = new Point2D(
          screenCenter.getX() + distanceFromCenter * Math.cos(angle),
          screenCenter.getY() + distanceFromCenter * Math.sin(angle));
      children.add(circle(satelliteCenter, radius, Color.YELLOW));
      children.add(circle(satelliteCenter, 6, Color.BLACK));
      children.add(circle(satelliteCenter, 4, Color.BLACK));
      children.add(circle(satelliteCenter, 5, Color.WHITE));

      angle += angleStep;
    }

    angle = 0;
    angleStep = 60;
    var lineLength = 1000;
    for (int i = 0; i < 6; i++) {
      Point2D lineDestination = new Point2D(
          screenCenter.getX() + lineLength * Math.cos(angle * Math.PI / 180),
          screenCenter.getY() + lineLength * Math.sin(angle * Math.PI / 180));
      children.add(line(screenCenter, lineDestination, Color.WHITE));
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
    stage.setFullScreen(true);
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