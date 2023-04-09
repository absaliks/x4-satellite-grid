package absaliks.jfxdraw.graphics;

import absaliks.jfxdraw.Geometry;
import absaliks.jfxdraw.State;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class RelativeCircle implements MutableShape {

  private final Circle circle;
  private final int radius;
  private final double distance;
  private final int angle;

  public RelativeCircle(State worldState, int radius, double distance, int angle, Color strokeColor) {
    this.circle = new Circle();
    this.circle.setStroke(strokeColor);
    this.circle.setFill(Color.TRANSPARENT);
    this.radius = radius;
    this.distance = distance;
    this.angle = angle;
    update(worldState);
  }

  @Override
  public void update(State state) {
    Point2D center = getCenter(state);
    circle.setCenterX(center.getX());
    circle.setCenterY(center.getY());
    circle.setRadius(state.scale() * radius);
  }

  private Point2D getCenter(State state) {
    return distance == 0 ? state.center() : Geometry.getDestination(state.center(), angle, distance * state.scale());
  }

  @Override
  public Shape getShape() {
    return circle;
  }
}
