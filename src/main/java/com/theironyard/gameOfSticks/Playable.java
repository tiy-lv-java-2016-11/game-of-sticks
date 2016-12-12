package com.theironyard.gameOfSticks;

/**
 * Created by melmo on 12/5/16.
 */
public interface Playable {
    int makeChoice(int sticks);
    void setWin(boolean win);
    String getName();
    int getRecord();
    void setRecord(int record);
}
