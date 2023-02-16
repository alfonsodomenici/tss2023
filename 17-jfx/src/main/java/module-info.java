module it.tss.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens it.tss.jfx to javafx.fxml;
    exports it.tss.jfx;
}
