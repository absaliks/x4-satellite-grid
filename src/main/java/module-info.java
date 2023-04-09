module absaliks.xsatellite {
  requires javafx.controls;
  requires javafx.fxml;


  opens absaliks.x4.satellite to javafx.fxml;
  exports absaliks.x4.satellite;
  exports absaliks.x4.satellite.graphics;
  opens absaliks.x4.satellite.graphics to javafx.fxml;
}