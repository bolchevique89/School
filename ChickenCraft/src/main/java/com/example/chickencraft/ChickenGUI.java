package com.example.chickencraft;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

public class ChickenGUI extends Application{
    public static void main(String[] args){
        launch(args);
    }
    /** interface for the ChickenCraft game */
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane bpane = new BorderPane(); //pane for start menu
        bpane.setPrefSize(350,150);
        VBox vbx = new VBox(); //pane for main menu
        // user inputs how many chickens to play with in textfield below
        TextField txtHowManyChickens = new TextField("How many chicken would you like to play with?");
        txtHowManyChickens.setPrefWidth(300);
        //button to initiate game which will populate interface with chickens, labels, and the main menu buttons
        Button btnStart = new Button ("Start");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String imgPath = "C:\\Users\\ealov\\Documents\\Information Technology\\" +
                                "Programming\\Java\\ChickenCraft\\src\\main\\java\\com\\example\\chickencraft\\chicken.png";
                Image imgChicken = new Image(imgPath);
                int howManyChickens = Integer.parseInt(txtHowManyChickens.getText());
                Chicken[] chicken = new Chicken[howManyChickens];
                ImageView[] imageView = new ImageView[howManyChickens]; //to store chicken images
                // information about each chicken stored in labels
                Label [] happyLbl = new Label[howManyChickens];
                Label [] lifeLbl = new Label[howManyChickens];
                Label [] nameLbl = new Label[howManyChickens];
                Label [] heartLbl = new Label[howManyChickens];
                Label [] seedLbl = new Label[howManyChickens];
                Label eggsLbl = new Label();
                // textfield to select which chicken to play with by number adjacent to name
                TextField txtChickenPicked = new TextField("Enter chicken's number");
                // main menu buttons to select which action to do with chicken
                Button btnHit = new Button("Hit the chicken");
                Button btnPlay = new Button("Play with another chicken");
                Button btnFeed= new Button("Feed the chicken");
                Button btnGetEggs = new Button("Take eggs from the chicken");
                Button btnNameChange = new Button("Change chicken's name");
                Button btnQuit = new Button("Quit");
                eggsLbl.setText("No eggs yet.");
                eggsLbl.setTextFill(Color.BLUE);
                // add all content above to main menu pane
                vbx.getChildren().addAll(txtChickenPicked, btnHit, btnPlay, btnFeed, btnGetEggs, btnNameChange, btnQuit, eggsLbl);
                int whichChicken;
                // sets as many objects as specified by number of chickens
                for(whichChicken = 0; whichChicken < howManyChickens; ++whichChicken) {
                    chicken[whichChicken] = new Chicken();
                    imageView[whichChicken] = new ImageView();
                    happyLbl[whichChicken] = new Label();
                    lifeLbl[whichChicken] = new Label();
                    nameLbl[whichChicken] = new Label();
                    heartLbl[whichChicken] = new Label();
                    seedLbl[whichChicken] = new Label();
                    updateStats(whichChicken, chicken[whichChicken], nameLbl[whichChicken], happyLbl[whichChicken],
                            seedLbl[whichChicken], heartLbl[whichChicken], lifeLbl[whichChicken]);
                    imageView[whichChicken].setImage(imgChicken);
                    vbx.getChildren().addAll(nameLbl[whichChicken], imageView[whichChicken], happyLbl[whichChicken],
                            lifeLbl[whichChicken], heartLbl[whichChicken], seedLbl[whichChicken]);
                }
                // hits chicken and updates stats
                btnHit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int chickenPicked = Integer.parseInt(txtChickenPicked.getText()) - 1;
                        chicken[chickenPicked].hit();
                        updateStats(chickenPicked, chicken[chickenPicked], nameLbl[chickenPicked], happyLbl[chickenPicked],
                                seedLbl[chickenPicked], heartLbl[chickenPicked], lifeLbl[chickenPicked]);
                    }
                });
                // two chickens play together and updates stats
                btnPlay.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int chickenPicked = Integer.parseInt(txtChickenPicked.getText()) - 1;
                        String stringNum = JOptionPane.showInputDialog("Enter the second chicken's number: ");
                        int secondChicken = Integer.parseInt(stringNum) - 1;
                        Chicken.play(chicken[chickenPicked],chicken[secondChicken]);
                        updateStats(chickenPicked, chicken[chickenPicked], nameLbl[chickenPicked], happyLbl[chickenPicked],
                                seedLbl[chickenPicked], heartLbl[chickenPicked], lifeLbl[chickenPicked]);
                    }
                });
                // chicken is fed and updates stats
                btnFeed.setOnAction((new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int chickenPicked = Integer.parseInt(txtChickenPicked.getText()) - 1;
                        chicken[chickenPicked].feed();
                        updateStats(chickenPicked, chicken[chickenPicked], nameLbl[chickenPicked], happyLbl[chickenPicked],
                                seedLbl[chickenPicked], heartLbl[chickenPicked], lifeLbl[chickenPicked]);
                    }
                }));
                // player collects eggs and updates stats
                btnGetEggs.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int chickenPicked = Integer.parseInt(txtChickenPicked.getText()) - 1;
                        int eggs = chicken[chickenPicked].collectEggs();
                        eggsLbl.setText("You have " + eggs + " eggs");
                        updateStats(chickenPicked, chicken[chickenPicked], nameLbl[chickenPicked], happyLbl[chickenPicked],
                                seedLbl[chickenPicked], heartLbl[chickenPicked], lifeLbl[chickenPicked]);
                    }
                });
                // player changes chicken's name and updates stats
                btnNameChange.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int chickenPicked = Integer.parseInt(txtChickenPicked.getText()) - 1;
                        String newName = JOptionPane.showInputDialog("Enter the chicken's new name: ");
                        chicken[chickenPicked].setName(newName);
                        updateStats(chickenPicked, chicken[chickenPicked], nameLbl[chickenPicked], happyLbl[chickenPicked],
                                seedLbl[chickenPicked], heartLbl[chickenPicked], lifeLbl[chickenPicked]);
                    }
                });
                // quits game
                btnQuit.setOnAction((new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.exit(0);
                    }
                }));

                Scene scene2 = new Scene(vbx);
                primaryStage.setTitle("ChickenCraft");
                primaryStage.setScene(scene2);
                primaryStage.show();
            }
        });
        bpane.setTop(txtHowManyChickens);
        bpane.setCenter(btnStart);
        Scene scene = new Scene(bpane);
        primaryStage.setTitle("ChickenCraft");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /** updates every visual stat of chicken player is currently play with */
    public void updateStats(int idxChicken, Chicken chicken, Label nameLbl, Label happyLbl, Label seedLbl, Label heartLbl, Label lifeLbl){
        String txtHappy, txtLife, txtHeart, txtSeed;
        if (chicken.isHappy()){
            txtHappy = "Happy";
        }
        else {
            txtHappy = "Sad";
        }
        if (chicken.isAlive()){
            txtLife = "Alive";
        }
        else {
            txtLife = "Dead";
        }
        txtHeart = "";
        for(int idx = 0; idx < chicken.getHearts(); idx++){
            txtHeart += "<3";
        }
        txtSeed = String.valueOf(chicken.getSeeds()) + " seeds";
        nameLbl.setText((idxChicken + 1) + " " + chicken.getName());
        nameLbl.setTextFill(Color.RED);
        happyLbl.setText(txtHappy);
        lifeLbl.setText(txtLife);
        heartLbl.setText(txtHeart);
        seedLbl.setText(txtSeed);
    }
}