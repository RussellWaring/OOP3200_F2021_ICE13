/** Main.java
 * @author          Russell Waring
 * @file            OOP3200 - ICE 12
 * @date            December 11, 2021
 * @description     The twelfth in-class exercise, during week 13 of OOP3200. Following along to a 2020 recording.
 */
package ca.durhamcollege.oop3200_f2021_ice13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"))
        stage.setTitle("Hello, World!");

        // Step 1 - create one or more controls
        Label helloLabel = new Label("Hello, World!");
        Label goodByeLabel = new Label("Good Bye!");

        // Step 1.1 - configure controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        Button clickMeButton = new Button("Click me");
        clickMeButton.setFont(font);

        // Step 1.2 - For button controls or other event-type controls - set the event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                helloLabel.setText("Clicked!");
            }
        });
        // Step 2 - create a container
        //HBox hbox = new HBox(helloLabel, goodByeLabel);
        //VBox vbox = new VBox(helloLabel, clickMeButton);

        GridPane gridPane = new GridPane();
        gridPane.add(helloLabel, 1, 0);
        gridPane.add(goodByeLabel, 1, 1);
        gridPane.add(clickMeButton, 2, 2);

        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
        stage.setScene(scene);

        // Step 5 - show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}