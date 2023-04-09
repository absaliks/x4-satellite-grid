package absaliks.x4.satellite.graphics;

import absaliks.x4.satellite.Geometry;
import absaliks.x4.satellite.State;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class RelativeLine implements MutableShape {

  private static final int LINE_LENGTH = 2000;

  private final Line line;
  private final int angle;

  public RelativeLine(State worldState, int angle, Color strokeColor) {
    this.line = new Line();
    this.line.setStroke(strokeColor);
    this.angle = angle;
    update(worldState);
  }

  /*
   angleStep = 60;
    var lineLength = 1000;
    for (int i = 0; i < 6; i++) {
      Point2D lineDestination = new Point2D(
          screenCenter.getX() + lineLength * Math.cos(angle * Math.PI / 180),
          screenCenter.getY() + lineLength * Math.sin(angle * Math.PI / 180));
      children.add(line(screenCenter, lineDestination, Color.WHITE));
  * */

  @Override
  public void update(State state) {
    Point2D start = Geometry.getDestination(state.center(), angle + 180, (double) LINE_LENGTH / 2);
    Point2D end = Geometry.getDestination(state.center(), angle, (double) LINE_LENGTH / 2);

    line.setStartX(start.getX());
    line.setStartY(start.getY());
    line.setEndX(end.getX());
    line.setEndY(end.getY());
  }

  @Override
  public Shape getShape() {
    return line;
  }
}
