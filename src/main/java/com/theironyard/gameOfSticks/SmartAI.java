package com.theironyard.gameOfSticks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by melmo on 12/8/16.
 */
public class SmartAI extends ComputerPlayer implements Playable {
    private ArrayList<Hat> brain = new ArrayList<>();

    public SmartAI(String name){
        super(name);
        for (int i = 0; i < 100; i++) {
            this.brain.add(new Hat(i));
        }
    }

    public void pushToBrain(boolean win){
        for (Hat hat : brain){
            Integer pick = hat.getPick();
            if (pick != 0) {
                ArrayList<Integer> choices = hat.getChoices();
                if (win){
                    choices.add(pick);
                    hat.setPick(0);
                }
                else {
                    int first = choices.indexOf(pick);
                    int last = choices.lastIndexOf(pick);
                    if (first != -1 && first != last){
                        choices.remove(pick);
                        hat.setPick(0);
                    }
                }
            }
        }
    }

    public ArrayList<Hat> getBrain(){
        return brain;
    }

    public void setBrain(ArrayList<Hat> brain){
        this.brain = brain;
    }

    @Override
    public int makeChoice(int sticks) {
        Hat hat = brain.get(sticks-1);
        ArrayList<Integer> choices = hat.getChoices();
        int bound = choices.size();
        Random rand = new Random();
        int pick = choices.get(rand.nextInt(bound));
        hat.setPick(pick);
        System.out.format("\n%s: I take %d sticks.", this.getName(), pick);
        return pick;
    }

    @Override
    public void setWin(boolean win){
        pushToBrain(win);
    }

}
