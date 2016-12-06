import java.util.Random;

/**
 * Created by melmo on 12/5/16.
 */
public class ComputerPlayer implements Playable {

    @Override
    public int makeChoice(int sticks) {
        int bound = Math.min(3, sticks);
        Random rand = new Random();
        int takeSticks = rand.nextInt(bound) + 1;
        System.out.format("\nComputer: I take %d sticks.", takeSticks);
        return takeSticks;
    }
}
