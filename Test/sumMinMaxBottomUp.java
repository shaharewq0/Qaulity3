import org.junit.Test;

import static org.junit.Assert.*;


public class sumMinMaxBottomUp {

    @Test(timeout = 100)
    public void sumMinMax() {

        assertEquals(7, Program.sumMinMax(new int[] {3,5,4,1,6,2}));
        assertEquals(2, Program.sumMinMax(new int[] {1,1,1,1}));
        assertEquals(4, Program.sumMinMax(new int[] {2}));

        //TODO : null?
        //TODO : empty?
    }
}
