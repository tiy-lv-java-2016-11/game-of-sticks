import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class Game {
    private int sticks;
    private Playable player1;
    private Playable player2;
    private Scanner input = new Scanner(System.in);
    private Scanner txtIn = new Scanner(Paths.get("gameHistory.txt"));
    private PrintWriter txtOut = new PrintWriter("gameHistory.txt");
    private HashMap<String, Integer> records = new HashMap<>();

    public Game() throws IOException {
        System.out.println("\nWelcome to the game of Sticks!");
        player1 = getPlayerType(1);
        player2 = getPlayerType(2);

        System.out.println("\nHow many sticks are there on the table initially (10-100)?");
        sticks = getValidInt(this.input.nextLine());
        while (sticks < 10 || sticks > 100){
            System.out.println("\nPlease enter a number between 10-100.");
            sticks = getValidInt(this.input.nextLine());
        }

        Playable whoLost = player2;
        Playable whoWon = player1;
        while (sticks > 0){
            System.out.format("\n\nThere are %d sticks on the board.", sticks);
            int takeSticks;
            if (whoLost.equals(player2)){
                sticks -= player1.makeChoice(sticks);
                whoLost = player1;
                whoWon = player2;
            }
            else {
                sticks -= player2.makeChoice(sticks);
                whoLost = player2;
                whoWon = player1;
            }
        }
        System.out.format("\nThe game is over. %s lost.", whoLost.getName());

        // Save to records
        if (records.containsKey(whoWon.getName())){
            records.replace(whoWon.getName(), records.get(whoWon.getName())+1);
        }
        else{
            records.put(whoWon.getName(), 1);
        }
        if (records.containsKey(whoLost.getName())){
            records.replace(whoLost.getName(), records.get(whoLost.getName())-1);
        }
        else{
            records.put(whoLost.getName(), -1);
        }

        System.out.println(records);
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

    private Playable getPlayerType(int num){
        Playable player = null;
        System.out.format("\nIs Player %d a human or a computer?", num);
        String type = this.input.nextLine();
        while(!type.equalsIgnoreCase("human") && !type.equalsIgnoreCase("computer")){
            System.out.println("\nPlease enter <human> or <computer>.");
            type = this.input.nextLine();
        }
        if (type.equalsIgnoreCase("human")){
            System.out.println("\nWhat is the human's name?");
            String name = getValidStr(this.input.nextLine());
            player = new HumanPlayer(name);
        }
        if (type.equalsIgnoreCase("computer")){
            System.out.println("\nWhat is the computer's name?");
            String name = getValidStr(this.input.nextLine());
            player = new ComputerPlayer(name);
        }
        return player;
    }

    private String getValidStr(String str){
        while (str.isEmpty()){
            System.out.println("\nPlease enter a value?");
            str = this.input.nextLine();
        }
        return str;
    }

}
