package com.theironyard.gameOfSticks;

import java.util.Scanner;

/**
 * Created by melmo on 12/8/16.
 */
public class Player {

    public static Playable createPlayer(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nIs the player a human or a computer?");
        String type = input.nextLine();
        while(!type.equalsIgnoreCase("human") && !type.equalsIgnoreCase("computer")){
            System.out.println("\nPlease enter <human> or <computer>.");
            type = input.nextLine();
        }
        if (type.equalsIgnoreCase("human")){
            System.out.println("\nWhat is the human's name?");
            String name = input.nextLine();
            while (name.isEmpty()){
                System.out.println("\nPlease enter a value?");
                name = input.nextLine();
            }
            return new HumanPlayer(name);
        }
        else {
            System.out.println("\nWhat is the computer's name?");
            String name = input.nextLine();
            while (name.isEmpty()){
                System.out.println("\nPlease enter a value?");
                name = input.nextLine();
            }
            System.out.println("Is the computer smart or dumb?");
            type = input.nextLine();
            while(!type.equalsIgnoreCase("smart") && !type.equalsIgnoreCase("dumb")){
                System.out.println("\nPlease enter <smart> or <dumb>.");
                type = input.nextLine();
            }
            if (!type.equalsIgnoreCase("smart")){
                return new SmartAI(name);
            }
            else {
                return new ComputerPlayer(name);
            }
        }
    }

//    private String getValidStr(String str){
//        while (str.isEmpty()){
//            System.out.println("\nPlease enter a value?");
//            str = this.input.nextLine();
//        }
//        return str;
//    }
}
