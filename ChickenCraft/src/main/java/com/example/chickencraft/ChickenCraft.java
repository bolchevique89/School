package com.example.chickencraft;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChickenCraft implements EventHandler<ActionEvent> {
    private static Scanner keyboard = new Scanner(System.in);
    private static int totalEggs = 0, collectedEggs = 0;
    public static void ChickenCraft(){
        System.out.println("How many chickens would you like to play with?");
        int howManyChickens = keyboard.nextInt();
        Chicken[] chickens = new Chicken[howManyChickens];
        int whichChicken;
        for(whichChicken = 0; whichChicken < howManyChickens; ++whichChicken) {
            chickens[whichChicken] = new Chicken();
        }
        for(whichChicken = 0; whichChicken < chickens.length; ++whichChicken) {
            chickens[whichChicken].toString();
        }
    }

    public static void menuChickenCraft(Chicken[] chickens){
        int response = 0;
        while(response!=6){
            System.out.println("Which chicken would you like to play with? (7 to quit)"); //chicken Home screen
            int whichChicken = keyboard.nextInt() - 1; //user specifies which chicken to play with
            int whichAction = 0;
            if(whichChicken!=6){ //when user enters 7, exit game
                do {
                    if(!chickens[whichChicken].isAlive()){ //else condition is executed only if chicken is alive
                        chickens[whichChicken].toString();
                        System.out.println(chickens[whichChicken].getName() + " is dead. " +
                                chickens[whichChicken].getName() + " can no longer play with you.");
                        break;
                    }
                    else { //else condition is the action menu for the user to specify how to play with the chicken
                        System.out.println("What would you like to do with the chicken?\n" +
                                "1. Hit the chicken.\n" +
                                "2. Play with another chicken.\n" +
                                "3. Feed the chicken.\n" +
                                "4. Take eggs from the chicken.\n" +
                                "5. Change name.\n" +
                                "6. Get stats.\n" +
                                "7. Choose a different chicken to play with.");
                        whichAction = keyboard.nextInt(); //registers which action user wants to take
                        if (whichAction == 1) {
                            chickens[whichChicken].hit();
                        } else if (whichAction == 2) {
                            System.out.println("Which second chicken?");
                            int which2ndChicken = keyboard.nextInt() - 1; //user selects which other chicken the present chicken plays with
                            Chicken.play(chickens[whichChicken], chickens[which2ndChicken]);
                        } else if (whichAction == 3) {
                            chickens[whichChicken].feed();
                        } else if (whichAction == 4) {
                            collectedEggs = chickens[whichChicken].collectEggs();
                            totalEggs += collectedEggs;
                            System.out.println(chickens[whichChicken].getName() + " gave you " + collectedEggs +
                                    " eggs. You now have " + totalEggs + " eggs in total.");
                        } else if (whichAction == 5) {
                            System.out.println("What is the chicken's new name?");
                            keyboard.nextLine();
                            String newName = keyboard.nextLine(); // user inputs new name for chicken
                            chickens[whichChicken].setName(newName);
                        } else if (whichAction == 6) {
                            chickens[whichChicken].toString();
                        }
                    }
                } while(whichAction!=7); //when user enters 7, return to chicken Home screen
            }
            response = whichChicken; //stores user input into response to check for exit game condition

        }
    }
    public void handle(ActionEvent event){
        System.out.println("This is fine");
    }
}
