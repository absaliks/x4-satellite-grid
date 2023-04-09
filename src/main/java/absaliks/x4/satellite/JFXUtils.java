package absaliks.x4.satellite;

import javafx.geometry.Point2D;
import javafx.stage.Screen;

public class JFXUtils {

  private JFXUtils() {
  }

  public static Point2D getScreenCenter() {
    var screenBounds = Screen.getPrimary().getBounds();
    return new Point2D(screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
  }
}
