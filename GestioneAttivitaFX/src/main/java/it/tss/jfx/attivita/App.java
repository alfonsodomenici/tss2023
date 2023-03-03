package it.tss.jfx.attivita;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage rootStage;

    @Override
    public void start(Stage stage) throws IOException {
        AttivitaStore.getInstance();
        rootStage = stage;
        scene = new Scene(loadFXML("attivitaGestione"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getRootStage() {
        return rootStage;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
