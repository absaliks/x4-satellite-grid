package absaliks.jfxdraw;

import javafx.geometry.Point2D;

public class Geometry {

  private Geometry() {
  }

  public static Point2D getDestination(Point2D start, int angle, double length) {
    double angleK = angle * Math.PI / 180;
    double x = start.getX() + Math.cos(angleK) * length;
    double y = start.getY() + Math.sin(angleK) * length;
    return new Point2D(x, y);
  }
}
