package absaliks.jfxdraw.graphics;

import absaliks.jfxdraw.State;
import javafx.scene.shape.Shape;

public interface MutableShape {

  Shape getShape();

  void update(State state);
}
