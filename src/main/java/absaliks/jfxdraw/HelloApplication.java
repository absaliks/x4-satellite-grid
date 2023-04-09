package absaliks.jfxdraw;

import absaliks.jfxdraw.graphics.MarkingLines;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {

  public void start(Stage primaryStage) {
    // Create a new scene and add the pane to it
    MarkingLines markingLines = new MarkingLines();
    Scene scene = new Scene(markingLines.getShapesGroup(), 800, 800);
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

//    Visibility
    scene.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.HOME) {
        stage.show();
      }
    });

    scene.setOnKeyReleased(event -> {
      if (event.getCode() == KeyCode.HOME) {
        stage.hide();
      }
    });
  }

  public static void main(String[] args) {
    launch(args);
  }
}