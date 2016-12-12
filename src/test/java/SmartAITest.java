import com.theironyard.gameOfSticks.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by melmo on 12/9/16.
 */
public class SmartAITest {

    SmartAI smartAI;

    @Before
    public void setup(){
        smartAI = new SmartAI("Sam");
    }

    @Test
    public void testMakeChoice(){

    }

    @Test
    public void testPushToBrainIfWin(){
        Hat hat = smartAI.getBrain().get(0);
        ArrayList<Integer> choices = hat.getChoices();

        Integer picked = 1;
        hat.setPick(picked);

        smartAI.pushToBrain(true);

        assertEquals("'choices' array is wrong size", 4, choices.size());
        Integer last = choices.get(choices.size()-1);
        assertEquals("last item in 'choices' array is wrong", picked, last);
    }

    @Test
    public void testPushToBrainIfLoseMoreThanOne(){
        Hat hat = smartAI.getBrain().get(0);
        ArrayList<Integer> choices = hat.getChoices();

        Integer picked = 1;
        hat.setPick(picked);
        choices.add(picked);

        smartAI.pushToBrain(false);

        assertEquals("'choices' array is wrong size", 3, choices.size());
        assertEquals("first item in 'choices' array is wrong", new Integer(2), choices.get(0));
    }

    @Test
    public void testPushToBrainIfLoseOnlyOne(){
        Hat hat = smartAI.getBrain().get(0);
        ArrayList<Integer> choices = hat.getChoices();

        Integer picked = 1;
        hat.setPick(picked);

        smartAI.pushToBrain(false);

        assertEquals("'choices' array is wrong size", 3, choices.size());
        assertEquals("first item in 'choices' array is wrong", picked, choices.get(0));
        Integer last = choices.get(choices.size()-1);
        assertEquals("last item in 'choices' array is wrong", new Integer(3), last);
    }
}
