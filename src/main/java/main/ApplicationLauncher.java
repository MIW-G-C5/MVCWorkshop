package main;

import javadb.DBaccess;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SceneManager;

import java.io.IOException;

public class ApplicationLauncher extends Application {
    private static Stage primaryStage;

    private static SceneManager sceneManager = null;
    private static DBaccess db = null;

    public static SceneManager getSceneManager() {
        if (sceneManager == null) {
            sceneManager = new SceneManager(primaryStage);
        }
        return sceneManager;
    }

    public static DBaccess getDBaccess() {
        if (db == null) {
            db = new DBaccess("Klanten","userKlanten", "pwKlanten");
        }
        return db;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        //getSceneManager().showWelcomeScene();
        //Stap 1: Hoe werkt een javaFX applicatie?
        // Zie de LauncherNoFXML


        //Stap 2: Hoe laadt je een fxml bestand? En wat is een fxml betand?
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CreateUpdateKlant.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*
        Stap 3: Uitleg elementen in een fxml-bestand, oa controls met event-handling
        Zie CreateUpdateKlant.fxml met bijbehorende controller.
        */

        /*
        Stap 4: Wat is een controller class? MVC architectuur ahv voorbeeld.
        Zie de controller als een soort Launcher class die koppelt dus View en Model classes (Customer en CustomerDAO)
        */

        /*
        Stap 5: Waarom een SceneManager? Wat doe die?
        Er is maar 1 SceneManager, singleton, hoe regel je dat?
        */

        /*
        Stap 6: View kan info nodig hebben, dat regelt de Controller.
        Hier gekozen voor setup() methode, zie voorbeelden:
        1) setup() van CreateUpdateKlantController
        2) setup() van KlantenLijstController
        */

        /*
        Stap 7: Verschillende soorten koppeling van fx-elementen
        1) fx-element, zoals een button, met een methode in FXML. Zie Save-button in CreateUpdateKlantController
        2) fx-element, zoals textfield, met een attribuut. @FXML en identieke naam.
        3) schrijven van eventHandler -> anonieme klasse -> handle() methode, zie WelcomeController
         */


    }




}
