module absaliks.jfxdraw {
    requires javafx.controls;
    requires javafx.fxml;


    opens absaliks.jfxdraw to javafx.fxml;
    exports absaliks.jfxdraw;
}