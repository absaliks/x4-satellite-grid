module absaliks.jfxdraw {
    requires javafx.controls;
    requires javafx.fxml;


    opens absaliks.jfxdraw to javafx.fxml;
    exports absaliks.jfxdraw;
  exports absaliks.jfxdraw.graphics;
  opens absaliks.jfxdraw.graphics to javafx.fxml;
}