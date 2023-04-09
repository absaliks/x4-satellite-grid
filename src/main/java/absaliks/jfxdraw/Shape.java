package absaliks.jfxdraw;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import static absaliks.jfxdraw.Utils.circle;
import static absaliks.jfxdraw.Utils.line;

public class Shape {

  public static final int SATELLITES_COUNT = 6;

  private static Point2D getEndPoint(Point2D start, int angle, double length) {
    double x = start.getX() + Math.cos(angle) * length;
    double y = start.getY() + Math.sin(angle) * length;
    return new Point2D(x, y);
  }


  public static Group draw() {
    Group root = new Group();
    root.setMouseTransparent(true);
    var children = root.getChildren();

    // Create the large center circle
    Point2D center = Utils.getScreenCenter();

    double radius = 325; // Radius of the smaller circles
    children.add(circle(center, radius, Color.RED));

    // Create the smaller circles around the center circle
    double angle = 0;
    double angleStep = 2 * Math.PI / SATELLITES_COUNT;
    double distanceFromCenter = radius / 0.585;

    for (int i = 0; i < SATELLITES_COUNT; i++) {

      Point2D satelliteCenter =
//          getEndPoint(center, angle, distanceFromCenter);
          new Point2D(
          center.getX() + distanceFromCenter * Math.cos(angle),
          center.getY() + distanceFromCenter * Math.sin(angle));
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
          center.getX() + lineLength * Math.cos(angle * Math.PI / 180),
          center.getY() + lineLength * Math.sin(angle * Math.PI / 180));
      children.add(line(center, lineDestination, Color.WHITE));
      angle += angleStep;
    }
    return root;
  }
}