import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class Game {
    private int sticks;
    private int whosTurn = 2;
    private Scanner input = new Scanner(System.in);

    public Game(){
        System.out.println("\nWelcome to the game of Sticks!\nHow many sticks are there on the table initially (10-100)?");
        sticks = getValidInt(this.input.nextLine());
        while (sticks < 10 || sticks > 100){
            System.out.println("Please enter a number between 10-100.");
            sticks = getValidInt(this.input.nextLine());
        }

        while (sticks > 0){
            if (whosTurn == 1){
                whosTurn = 2;
            }
            else {
                whosTurn = 1;
            }
            System.out.format("\nThere are %d sticks on the board.", sticks);
            System.out.format("\nPlayer %d: How many sticks do you take (1-3)?", whosTurn);
            int takeSticks = getValidInt(this.input.nextLine());
            while (takeSticks < 1 || takeSticks > 3 || takeSticks > sticks){
                System.out.println("\nPlease enter a valid number.");
                takeSticks = getValidInt(this.input.nextLine());
            }
            sticks -= takeSticks;
        }
        System.out.format("\nThe game is over. Player %d lost.", whosTurn);
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
