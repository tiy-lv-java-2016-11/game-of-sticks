package com.theironyard.gameOfSticks;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Game game = new Game();

        Playable player1 = Player.createPlayer();
        Playable player2 = Player.createPlayer();

        int sticks = game.getStartSticks();

        for (int i = 0; i < 100; i++) {
            game.play(player1, player2, sticks);
        }


    }

}
