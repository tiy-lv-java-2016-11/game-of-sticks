package com.theironyard.gameOfSticks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by melmo on 12/8/16.
 */
public class Hat {
    private int ID;
    private ArrayList<Integer> choices = new ArrayList<>();
    private Integer pick = 0;

    public Hat(){}

    public Hat(int ID) {
        this.ID = ID;
        this.choices.addAll(Arrays.asList(1, 2, 3));
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Integer> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Integer> choices) {
        this.choices = choices;
    }

    public Integer getPick() {
        return this.pick;
    }

    public void setPick(Integer pick) {
        this.pick = pick;
    }
}
