package com.theironyard.gameOfSticks;

import java.util.Random;

/**
 * Created by melmo on 12/5/16.
 */
public class ComputerPlayer implements Playable {
    private String name;
    private int record;
    private boolean win = false;

    public ComputerPlayer(String name) {
        this.name = name + " the AI";
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
        int bound = Math.min(3, sticks);
        Random rand = new Random();
        int takeSticks = rand.nextInt(bound) + 1;
        System.out.format("\n%s: I take %d sticks.", this.getName(), takeSticks);
        return takeSticks;
    }

}
