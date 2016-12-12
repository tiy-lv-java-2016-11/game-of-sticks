package com.theironyard.gameOfSticks;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class Game {
    private Scanner input = new Scanner(System.in);
    private HashMap<String, Integer> records = new HashMap<>();

    public Game() throws IOException {
        System.out.println("\nWelcome to the game of Sticks!");
    }

    /*
     * Plays a single round of sticks
     * @param player1 Starting player
     * @param player2 Other player
     * @param sticks Number of sticks to start game
     */
    public void play(Playable player1, Playable player2, int sticks) throws IOException {
        Playable currentPlayer = player1;

        while (sticks > 0){
            System.out.format("\n\nThere are %d sticks on the board.", sticks);

            if (currentPlayer.equals(player1)){
                sticks -= player1.makeChoice(sticks);
                currentPlayer = player2;
            }
            else {
                sticks -= player2.makeChoice(sticks);
                currentPlayer = player1;
            }
        }
        currentPlayer.setWin(true);
        putRecords(currentPlayer, player1, player2);
    }

    /*
    * Ask user to input number of sticks to start game
    * and returns that number
    */
    public int getStartSticks(){
        System.out.println("\nHow many sticks are there on the table initially (10-100)?");
        int sticks = getValidInt(input);
        while (sticks < 10 || sticks > 100){
            System.out.println("\nPlease enter a number between 10-100.");
            sticks = getValidInt(input);
        }
        return sticks;
    }

//    private void playAgain(){
//        System.out.println("\nWould you like to play again? Y/N");
//        String again = this.input.nextLine();
//        if (again.equalsIgnoreCase("n")){
//            playing = false;
//            System.out.println("\nThank you for playing. Saving records....");
//            saveRecords();
//        }
//        if (again.equalsIgnoreCase("y")){
//            System.out.println("\nWould you like create new players? Y/N");
//            if (this.input.nextLine().equalsIgnoreCase("y")){
//                initPlayers();
//            }
//        }
//    }

    public void putRecords(Playable currentPlayer, Playable player1, Playable player2){
        if (player1.equals(currentPlayer)){
            player1.setRecord(player1.getRecord()+1);
            player2.setRecord(player2.getRecord()-1);
        }
        else {
            player1.setRecord(player1.getRecord()-1);
            player2.setRecord(player2.getRecord()+1);
        }
        System.out.format("%s : %d\n%s : %d", player1.getName(), player1.getRecord(), player2.getName(), player2.getRecord());
    }

    public void saveRecords() throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(records);
        System.out.println(json);

        File f = new File("records.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public HashMap loadRecords() throws FileNotFoundException {
        File f = new File("records.json");
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter("\\Z");
        String records = scanner.next();

        JsonParser parser = new JsonParser();
        System.out.println(parser.parse(records).toString());
        return parser.parse(records);
    }

    private int getValidInt(Scanner input) {
        while(!input.hasNextInt()){
            System.out.println("\nPlease enter a valid number.");
            input.next();
        }
        int num = input.nextInt();
        input.nextLine();
        return num;
    }

}
