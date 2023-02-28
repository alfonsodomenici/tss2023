module it.tss.jfx.attivita {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens it.tss.jfx.attivita to javafx.fxml;
    exports it.tss.jfx.attivita;
}
