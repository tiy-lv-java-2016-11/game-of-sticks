import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class Game {
    private int sticks;
    private String whosTurn = "computer";
    private Playable human = new HumanPlayer();
    private Playable computer = new ComputerPlayer();
    private Scanner input = new Scanner(System.in);

    public Game(){
        System.out.println("\nWelcome to the game of Sticks!\nHow many sticks are there on the table initially (10-100)?");
        sticks = getValidInt(this.input.nextLine());
        while (sticks < 10 || sticks > 100){
            System.out.println("\nPlease enter a number between 10-100.");
            sticks = getValidInt(this.input.nextLine());
        }

        while (sticks > 0){
            System.out.format("\n\nThere are %d sticks on the board.", sticks);
            int takeSticks;
            if (whosTurn == "computer"){
                sticks -= human.makeChoice(sticks);
                whosTurn = "human";
            }
            else {
                sticks -= computer.makeChoice(sticks);
                whosTurn = "computer";
            }
        }
        System.out.format("\nThe game is over. The %s lost.", whosTurn);
    }

    private int getValidInt(String str) {
        try {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            System.out.println("\nPlease enter a valid number.");
            return -1;
        }
    }


}
