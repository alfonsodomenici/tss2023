module it.tss.jfx.attivita {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.validation;
    
    opens it.tss.jfx.attivita to javafx.fxml, org.hibernate.validator;
    exports it.tss.jfx.attivita;
}
