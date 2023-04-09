package absaliks.jfxdraw.graphics;

import absaliks.jfxdraw.JFXUtils;
import absaliks.jfxdraw.State;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class MarkingLines {

  public static final int SATELLITES_COUNT = 6;

  private int radius = 300;

  private final List<MutableShape> mutableShapes = new ArrayList<>();

  public MarkingLines() {
    init();
  }

  private void init() {
    Point2D screenCenter = JFXUtils.getScreenCenter();
    State state = new State(screenCenter, 1);
    mutableShapes.add(new RelativeCircle(state, radius, 0, 0, Color.RED));

    int angleStep = 360 / SATELLITES_COUNT;
    double distanceFromCenter = radius / 0.585;
    for (int i = 0; i < SATELLITES_COUNT; i++) {
      mutableShapes.add(new RelativeCircle(state, radius, distanceFromCenter, angleStep * i, Color.YELLOW));
      mutableShapes.add(new RelativeCircle(state, 6, distanceFromCenter, angleStep * i, Color.BLACK));
      mutableShapes.add(new RelativeCircle(state, 5, distanceFromCenter, angleStep * i, Color.WHITE));
      mutableShapes.add(new RelativeCircle(state, 4, distanceFromCenter, angleStep * i, Color.BLACK));
    }

    mutableShapes.add(new RelativeLine(state, 60, Color.AQUA));
    mutableShapes.add(new RelativeLine(state, 120, Color.AQUA));
  }

  public Group getShapesGroup() {
    Group root = new Group();
    var children = root.getChildren();
    mutableShapes.forEach(ms -> children.add(ms.getShape()));
    return root;
  }
}