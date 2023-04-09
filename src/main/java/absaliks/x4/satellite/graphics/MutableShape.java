package absaliks.x4.satellite.graphics;

import absaliks.x4.satellite.State;
import javafx.scene.shape.Shape;

public interface MutableShape {

  Shape getShape();

  void update(State state);
}
