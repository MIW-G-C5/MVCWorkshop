package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LauncherNoFXML extends Application {

    TextField tekst;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Stap 1: Hoe werkt een javaFX applicatie?
        Pane root = new AnchorPane();
        // Knop maken, toevoegen en op zijn plek zetten.
        Button knoppie = new Button("Klik hier eens");
        root.getChildren().add(knoppie);
        AnchorPane.setTopAnchor(knoppie, 50.0);
        AnchorPane.setLeftAnchor(knoppie, 70.0);
        // Tekstveld maken, toevoegen en op zijn plek zetten
        tekst = new TextField("Hier staat iets.");
        root.getChildren().add(tekst);
        AnchorPane.setTopAnchor(tekst,100.0);
        // Een Scene maken van de root Pane en toevoegen aan de primaryStage.
        Scene myFirstScene = new Scene(root, 600, 400);
        primaryStage.setScene(myFirstScene);
        primaryStage.show();
        // eventHandler voor de knop, als anonieme klasse.
        /*knoppie.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tekst.setText("Je hebt geklikt");
            }
        });*/

        // eventHandle voor knop met lambda expressie
         knoppie.setOnAction(event -> tekst.setText("Je hebt geklikt"));

    }
}