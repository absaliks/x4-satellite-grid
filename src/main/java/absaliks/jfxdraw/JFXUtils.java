package absaliks.jfxdraw;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Screen;

public class JFXUtils {

  public static Point2D getScreenCenter() {
    var screenBounds = Screen.getPrimary().getBounds();
    return new Point2D(screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
  }

  static Circle circle(Point2D center, double radius, Color strokeColor) {
    var c = new Circle(center.getX(), center.getY(), radius);
    c.setStroke(strokeColor);
    c.setFill(Color.TRANSPARENT);
    return c;
  }

  static Line line(Point2D a, Point2D b, Color strokeColor) {
    var l = new Line(a.getX(), a.getY(), b.getX(), b.getY());
    l.setStroke(strokeColor);
    return l;
  }
}
