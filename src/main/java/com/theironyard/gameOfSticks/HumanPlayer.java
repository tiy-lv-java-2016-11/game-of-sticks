package com.theironyard.gameOfSticks;

import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class HumanPlayer implements Playable{
    private Scanner input = new Scanner(System.in);
    private String name;
    private int record;
    private boolean win = false;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecord() {
        return record;
    }

    @Override
    public void setRecord(int record) {
        this.record = record;
    }

    public boolean isWin() {
        return win;
    }

    @Override
    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public int makeChoice(int sticks) {
        System.out.println("\nHuman: How many sticks do you take (1-3)?");
        int takeSticks = getValidInt(this.input.nextLine());
        while (takeSticks > sticks|| takeSticks > 3 || takeSticks < 1 ){
            System.out.println("\nPlease enter a valid number.");
            takeSticks = getValidInt(this.input.nextLine());
        }
        return takeSticks;
    }

    private int getValidInt(String str) {
        while(!input.hasNextInt()){
            System.out.println("\nPlease enter a valid number.");
            input.next();
        }
        int num = input.nextInt();
        input.nextLine();
        return num;
    }


}
