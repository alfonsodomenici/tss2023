module it.tss.xx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens it.tss.xx to javafx.fxml;
    exports it.tss.xx;
}
