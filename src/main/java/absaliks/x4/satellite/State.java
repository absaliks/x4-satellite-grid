package absaliks.x4.satellite;

import javafx.geometry.Point2D;

public record State (
   Point2D center,
   double scale
) {
  public static final State DEFAULT = new State(JFXUtils.getScreenCenter(), 1);
  
  public StateAdjuster toAdjuster() {
    return new StateAdjuster(center.getX(), center.getY(), scale);
  }

  public static class StateAdjuster {
    private double x;
    private double y;
    private double scale;

    private boolean isChanged;

    public StateAdjuster(double x, double y, double scale) {
      this.x = x;
      this.y = y;
      this.scale = scale;
    }

    public void incX(double delta) {
      x += delta;
      setChanged();
    }

    public void incY(double delta) {
      y += delta;
      setChanged();
    }

    public void incScale(double delta) {
      scale += delta;
      if (scale < 0) {
        scale = 0;
      } else {
        setChanged();
      }
    }

    private void setChanged() {
      isChanged = true;
    }

    public boolean isChanged() {
      return isChanged;
    }

    public State build() {
      return new State(
          new Point2D(x, y),
          scale);
    }
  }
}
