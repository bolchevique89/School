package com.example.chickencraft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);

        Image img = new Image("C:\\Users\\ealov\\Documents\\Java\\ChickenCraft\\src\\main\\java\\com\\example\\chickencraft\\chicken.png");
        Canvas canvas = new Canvas(400,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(img, 1, 1);

        root.getChildren().add(canvas);
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}