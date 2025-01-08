package com.example.chickencraft;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawCircle extends Application
{
    // TODO:

    // TODO:
    Button button = new Button("Draw Circle");
    Label label = new Label("Radius:");
    TextField tf = new TextField("num");

    // This is where you create your components
    @Override
    public void start(Stage stage) throws Exception
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);      // set window size here
        Canvas canvas = new Canvas(400,400);       // set canvas size here
        stage.setTitle("Draw Circle");                   // set window title here
        stage.setScene(scene);

        // TODO:
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int radius = Integer.parseInt(tf.getText());
                gc.setFill(Color.GREEN);
                gc.fillOval(100+radius,100+radius,radius, radius);
            }
        });
        button.setPrefWidth(500);
        root.setStyle("-fx-background-color: light blue");
        root.add(canvas,0, 0);
        root.add(label,0, 1);
        root.add(tf,2, 1);
        root.add(button,3, 1);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}