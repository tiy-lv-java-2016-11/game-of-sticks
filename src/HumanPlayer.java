import java.util.Scanner;

/**
 * Created by melmo on 12/5/16.
 */
public class HumanPlayer implements Playable{
    private Scanner input = new Scanner(System.in);

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
        try {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            System.out.println("\nPlease enter a valid number.");
            return -1;
        }
    }

}
