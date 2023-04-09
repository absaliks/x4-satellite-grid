package absaliks.x4.satellite;

import javafx.animation.AnimationTimer;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.EnumSet;
import java.util.HashSet;

class KeyController {

  public static final int MOVE_DELTA_NORMAL = 1;
  public static final int MOVE_DELTA_FAST = 5;
  public static final double SCALE_DELTA_NORMAL = 0.002;
  public static final double SCALE_DELTA_FAST = 0.01;

  private static final EnumSet<KeyCode> BOUND_KEYS = EnumSet.of(
      KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D,
      KeyCode.Q, KeyCode.E,
      KeyCode.SHIFT, KeyCode.HOME);

  private final HashSet<KeyCode> pressedKeys = new HashSet<>(BOUND_KEYS.size());
  private final SimpleBooleanProperty hasPressed = new SimpleBooleanProperty(false);

  public KeyController(Property<State> state$) {
    AnimationTimer animationTimer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (pressedKeys.contains(KeyCode.HOME)) state$.setValue(State.DEFAULT);

        var stateAdjuster = state$.getValue().toAdjuster();

        final var moveDelta = pressedKeys.contains(KeyCode.SHIFT) ? MOVE_DELTA_FAST : MOVE_DELTA_NORMAL;
        if (pressedKeys.contains(KeyCode.W)) stateAdjuster.incY(-moveDelta);
        if (pressedKeys.contains(KeyCode.S)) stateAdjuster.incY(moveDelta);
        if (pressedKeys.contains(KeyCode.A)) stateAdjuster.incX(-moveDelta);
        if (pressedKeys.contains(KeyCode.D)) stateAdjuster.incX(moveDelta);

        final var scaleDelta = pressedKeys.contains(KeyCode.SHIFT) ? SCALE_DELTA_FAST : SCALE_DELTA_NORMAL;
        if (pressedKeys.contains(KeyCode.Q)) stateAdjuster.incScale(-scaleDelta);
        if (pressedKeys.contains(KeyCode.E)) stateAdjuster.incScale(scaleDelta);

        if (stateAdjuster.isChanged()) state$.setValue(stateAdjuster.build());
      }
    };

    hasPressed.addListener((obs, oldValue, newValue) -> {
      if (newValue)
        animationTimer.start();
      else
        animationTimer.stop();
    });
  }

  public void onKeyDown(KeyEvent event) {
    if (BOUND_KEYS.contains(event.getCode())) {
      pressedKeys.add(event.getCode());
      hasPressed.set(true);
    }
  }

  public void onKeyUp(KeyEvent event) {
    pressedKeys.remove(event.getCode());
    if (pressedKeys.isEmpty()) {
      hasPressed.set(false);
    }
  }
}
