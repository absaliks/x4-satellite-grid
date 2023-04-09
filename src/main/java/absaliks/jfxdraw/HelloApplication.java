package absaliks.jfxdraw;

import absaliks.jfxdraw.graphics.MarkingLines;
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {

  public static final State DEFAULT_STATE = new State(JFXUtils.getScreenCenter(), 1);
  private final Property<State> state$ = new SimpleObjectProperty<>(DEFAULT_STATE);
  private final KeyController keyController = new KeyController(state$);


  public void start(Stage primaryStage) {
    var markingLines = new MarkingLines(state$.getValue());

    var scene = new Scene(markingLines.getShapesGroup(), 800, 800);
    scene.setFill(Color.TRANSPARENT);
    scene.setOnKeyPressed(keyController::onKeyDown);
    scene.setOnKeyReleased(keyController::onKeyUp);

    var stage = new Stage();
    stage.setFullScreen(true);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.setAlwaysOnTop(true);
    stage.show();

    state$.addListener((obs, oldValue, newValue) -> markingLines.update(newValue));
  }

  public static void main(String[] args) {
    launch(args);
  }
}