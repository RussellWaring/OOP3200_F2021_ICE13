/** Main.java
 * @author          Russell Waring
 * @file            OOP3200 - ICE 13
 * @date            December 17, 2021
 * @description     The thirteenth in-class exercise, during week 14 of OOP3200. Following along to a 2020 recording.
 */
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello, World!");

        // Step 1 - create one or more controls
        Label imageLabel = new Label("Xbox Series X!");

        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial");

        FileInputStream imagePath = new FileInputStream("src/resources/sample/xboxseriesx.jpg");

        // Step 1 for images - load the image
        Image xboxSeriesX = new Image(imagePath);

        // Step 2 for images - setup a ImageView to "contain it"
        ImageView consoleImageView = new ImageView(xboxSeriesX);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream ps5Path = new FileInputStream("src/resources/sample/ps5.jpg");
        Image ps5 = new Image(ps5Path);
        //ImageView ps5ImageView = new ImageView(ps5);

        // Step 1.1 - configure controls
        //Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        //clickMeButton.setFont(font);

        /**
         * A button click handler; event handler that sits outside of button.
         * Oddly satisfying.
         */
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(!imageLabel.getText().equals("PS5!"))
                {
                    imageLabel.setText("PS5!");
                    consoleImageView.setImage(ps5);
                }
                else
                {
                    imageLabel.setText("Xbox Series X!");
                    consoleImageView.setImage(xboxSeriesX);
                }
            }
        }

        clickMeButton.setOnAction(new ButtonClickHandler());

        // Step 1.2 - For button controls or other event-type controls - set the event
        /*clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            } A DELEGATE OR ANONYMOUS FUNCTION
        });*/
        // Step 2 - create a container
        HBox hbox = new HBox(10, imageLabel);
        hbox.setStyle("-fx-alignment: center;");

        HBox hbox2 = new HBox(10, consoleImageView);
        hbox2.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6, 8);
        gridPane.setVgap(10); // spacing
        gridPane.setHgap(10); // spacing
        gridPane.setPadding(new Insets(10)); // padding

        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        gridPane.add(consoleImageView, 0, 2);
        gridPane.add(clickMeButton, 2, 2);

        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");

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